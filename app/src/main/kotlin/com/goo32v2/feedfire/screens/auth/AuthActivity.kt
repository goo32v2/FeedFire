package com.goo32v2.feedfire.screens.auth

import android.accounts.AccountAuthenticatorResponse
import android.accounts.AccountManager
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.arellomobile.mvp.presenter.InjectPresenter
import com.goo32v2.feedfire.R
import com.goo32v2.feedfire.screens.BaseActivity
import kotlinx.android.synthetic.main.activity_auth.*


/**
 * @author Alexander Steblin (goo32v2)
 * @date 02.04.2017
 */
class AuthActivity : BaseActivity(R.layout.activity_auth), IAuthView {

    companion object {
        val KEY_AUTH_TYPE = "KEY_AUTH_TYPE"
    }

    @InjectPresenter lateinit var authPresenter: AuthPresenter

    lateinit private var accountAuthenticatorResponse: AccountAuthenticatorResponse
    lateinit private var resultBundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        accountAuthenticatorResponse = intent.getParcelableExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE)
        accountAuthenticatorResponse.onRequestContinued()
    }

    override fun initWebView(url: String, onRedirect: (request: WebResourceRequest?) -> Unit) {
        webView.isEnabled = true

        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.settings.useWideViewPort = false
        webView.settings.userAgentString = "Mozilla/5.0 Google"
        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                onRedirect(request)
                return false
            }
        }
        webView.loadUrl(url)
    }

    override fun finish() {
        // send the result bundle back if set, otherwise send an error.
        accountAuthenticatorResponse.onResult(resultBundle)
        super.finish()
    }

    override fun setAccountAuthenticatorResult(result: Bundle) {
        resultBundle = result
    }
}
