package com.goo32v2.feedfire.facades

import android.accounts.Account
import android.os.Bundle
import com.goo32v2.feedfire.providers.ino.models.Token
import com.goo32v2.feedfire.providers.ino.models.User

/**
 * @author Alexander Steblin (goo32v2)
 * @date 01.10.2017
 */
interface IAccountFacade {

    fun createAccount(user: User?, token: Token?): Bundle?

    fun getAccount(): Account?

    fun getAccountType(): String

    fun getLocalTokenAndRefreshIfNeeded(): String?

    fun updateAuthToken(token: String)

    fun getParamForKey(key: String): String

    fun saveParam(key: String, value: String)

    fun saveParams(params: Map<String, String>)

    fun createResultBundle(account: Account?, token: String): Bundle

    fun makeOAuthForCode(code: String): Pair<User?, Token?>
}