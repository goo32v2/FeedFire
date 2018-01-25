package com.goo32v2.feedfire.facades.impl

import android.accounts.Account
import android.accounts.AccountManager
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.goo32v2.feedfire.BuildConfig
import com.goo32v2.feedfire.extentions.edit
import com.goo32v2.feedfire.extentions.set
import com.goo32v2.feedfire.facades.IAccountFacade
import com.goo32v2.feedfire.providers.ino.models.Token
import com.goo32v2.feedfire.providers.ino.models.User
import com.goo32v2.feedfire.providers.ino.services.ITokenService
import com.goo32v2.feedfire.providers.ino.services.IUserService
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 01.10.2017
 */

@Singleton
class AccountFacade @Inject constructor(private val am: AccountManager,
                                        private val tokenService: ITokenService,
                                        private val userService: IUserService,
                                        private val sharedPreferences: SharedPreferences) : IAccountFacade {

    companion object {
        val TAG: String = this::class.java.name
        val ACCESS_TOKEN = "access_token"
        val EXPIRES_IN = "expires_in"
        val REFRESH_TOKEN = "refresh_token"
    }

    override fun createAccount(user: User?, token: Token?): Bundle? {
        if (user != null && token != null) {
            val account = Account(user.userName, getAccountType())
            if (am.addAccountExplicitly(account, "", Bundle())) {
                am.setAuthToken(account, account.type, token.accessToken)
                saveUserDataInAccountManager(user, token)
            }
            return createResultBundle(account, token.accessToken)
        }
        return null
    }

    override fun createResultBundle(account: Account?, token: String): Bundle {
        val result = Bundle()
        result.putString(AccountManager.KEY_ACCOUNT_NAME, account?.name)
        result.putString(AccountManager.KEY_ACCOUNT_TYPE, account?.type)
        result.putString(AccountManager.KEY_AUTHTOKEN, token)
        return result
    }

    override fun getLocalTokenAndRefreshIfNeeded(): String? = runBlocking {
        // get token
        val account = getAccount()
        if (account != null) {
            var token = am.peekAuthToken(account, getAccountType())
            if (!token.isNullOrEmpty()) {
                val expireDate = getParamForKey(EXPIRES_IN).toLong()
                val currentTime = System.currentTimeMillis()
                if (expireDate < currentTime) {
                    Log.i(TAG, "Token $token expired! Try to refresh")
                    // token expired, try to refresh
                    val refreshToken = getParamForKey(REFRESH_TOKEN)
                    if (refreshToken.isNotEmpty()) {
                        val deferred = async(CommonPool) { tokenService.refreshToken(refreshToken) }
                        token = deferred.await()?.accessToken
                        Log.i(TAG, "Token refreshed! New token $token")
                        am.setAuthToken(getAccount(), getAccountType(), token)
                    }
                }
            }
            saveTokenAndExpirationDateInPreferences(token)
            return@runBlocking token
        }

        return@runBlocking null
    }

    override fun saveParams(params: Map<String, String>) {
        for (entry in params.entries) {
            saveParam(entry.key, entry.value)
        }
    }

    override fun updateAuthToken(token: String) = am.setAuthToken(getAccount(), getAccountType(), token)

    override fun getParamForKey(key: String): String = am.getUserData(getAccount(), key)

    override fun saveParam(key: String, value: String) = am.setUserData(getAccount(), key, value)

    override fun getAccount(): Account? {
        val accountsByType = am.getAccountsByType(getAccountType())
        if (accountsByType.isEmpty()) {
//            ctx.startActivityFo()
        }
        return accountsByType.getOrNull(0)
    }

    override fun makeOAuthForCode(code: String): Pair<User?, Token?> = runBlocking {
        val token = async(CommonPool) { tokenService.getToken(code) }
        val user = async(CommonPool) { userService.getUserProfileForToken(token.await()?.accessToken!!) }
        return@runBlocking Pair(user.await(), token.await())
    }

    override fun getAccountType(): String = BuildConfig.APPLICATION_ID + ".inoreader"

    private fun saveTokenAndExpirationDateInPreferences(token: String) {
            sharedPreferences.edit {
                set(ACCESS_TOKEN to token)
                set(EXPIRES_IN to getParamForKey(EXPIRES_IN))
            }
    }

    private fun saveUserDataInAccountManager(user: User, token: Token) {
        val map = HashMap<String, String>()
        map.put("userId", user.userId.toString())
        map.put("userEmail", user.userEmail)
        map.put("refresh_token", token.refreshToken)
        map.put("token_type", token.tokenType)
        map.put("expires_in", token.expiresIn.toString())
        saveParams(map)
    }
}