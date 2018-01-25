package com.goo32v2.feedfire.screens.auth

import android.app.Activity
import com.arellomobile.mvp.InjectViewState
import com.goo32v2.feedfire.di.GraphManager
import com.goo32v2.feedfire.facades.IAccountFacade
import com.goo32v2.feedfire.providers.ino.InoreaderClient
import com.goo32v2.feedfire.providers.ino.models.Token
import com.goo32v2.feedfire.providers.ino.models.User
import com.goo32v2.feedfire.screens.BasePresenter
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

/**
 * @author Alexander Steblin (goo32v2)
 * @date 5/30/17
 */

@InjectViewState
class AuthPresenter : BasePresenter<IAuthView>(), IAuthPresenter {

    @Inject lateinit var accountFacade: IAccountFacade

    init {
        GraphManager.applicationGraph.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initWebView(InoreaderClient.buildOathUserUrl(),
                { request ->
                    request!!.url.queryParameterNames.forEach {
                        if ("code" == it) {
                            launch(UI) {
                                val userAndToken = accountFacade.makeOAuthForCode(request.url.getQueryParameter(it))
                                onTokenReceived(userAndToken.first, userAndToken.second)
                            }
                        }
                    }
                })
    }

    override fun onTokenReceived(user: User?, token: Token?) {
        val result = accountFacade.createAccount(user, token)
        if (result != null) {
            viewState.setAccountAuthenticatorResult(result)
            viewState.setResult(Activity.RESULT_OK)
        } else {
            viewState.setResult(Activity.RESULT_CANCELED)
        }
        viewState.finish()
    }
}