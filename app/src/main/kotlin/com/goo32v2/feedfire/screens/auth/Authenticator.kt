package com.goo32v2.feedfire.screens.auth

import android.accounts.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.goo32v2.feedfire.facades.IAccountFacade
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */

@Singleton
class Authenticator @Inject constructor(private val ctx: Context, private val accountFacade: IAccountFacade) : AbstractAccountAuthenticator(ctx) {

    companion object {
        val name: String = this::class.java.name
    }

    @Throws(NetworkErrorException::class)
    override fun getAuthTokenLabel(authTokenType: String?): String {
        TODO("not implemented")
    }

    @Throws(NetworkErrorException::class)
    override fun confirmCredentials(response: AccountAuthenticatorResponse?, account: Account?, options: Bundle?): Bundle {
        TODO("not implemented")
    }

    @Throws(NetworkErrorException::class)
    override fun updateCredentials(response: AccountAuthenticatorResponse?, account: Account?, authTokenType: String?, options: Bundle?): Bundle {
        TODO("not implemented")
    }

    @Throws(NetworkErrorException::class)
    override fun getAuthToken(response: AccountAuthenticatorResponse?, account: Account?, authTokenType: String?, options: Bundle?): Bundle {
        Log.d(name, "getAuthToken() called")

        val token = accountFacade.getLocalTokenAndRefreshIfNeeded()

        // return bundle with token if service it
        if (!token.isNullOrEmpty()) {
            return accountFacade.createResultBundle(account, token!!)
        }

        // start activity
        return getAuthActivityBundle(authTokenType, response, options)
    }

    @Throws(NetworkErrorException::class)
    override fun hasFeatures(response: AccountAuthenticatorResponse?, account: Account?, features: Array<out String>?): Bundle {
        TODO("not implemented")
    }

    @Throws(NetworkErrorException::class)
    override fun editProperties(response: AccountAuthenticatorResponse?, accountType: String?): Bundle {
        TODO("not implemented")
    }


    @Throws(NetworkErrorException::class)
    override fun addAccount(response: AccountAuthenticatorResponse?,
                            accountType: String?, authTokenType: String?,
                            requiredFeatures: Array<out String>?,
                            options: Bundle?): Bundle {
        Log.d(name, "getAuthActivityBundle() called")
        return getAuthActivityBundle(accountType, response, options)
    }

    private fun getAuthActivityBundle(accountType: String?, response: AccountAuthenticatorResponse?, options: Bundle?): Bundle {
        val intent = Intent(ctx, AuthActivity::class.java)
        intent.putExtra(AuthActivity.KEY_AUTH_TYPE, accountType)
        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response)

        val bundle = Bundle()
        if (options != null) {
            bundle.putAll(options)
        }

        bundle.putParcelable(AccountManager.KEY_INTENT, intent)
        return bundle
    }


}