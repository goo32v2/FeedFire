package com.goo32v2.feedfire.screens.auth

import android.os.Bundle
import android.webkit.WebResourceRequest
import com.goo32v2.feedfire.screens.IBaseView

/**
 * @author Alexander Steblin (goo32v2)
 * @date 5/30/17
 */

interface IAuthView : IBaseView {

    fun initWebView(url : String, onRedirect: (request: WebResourceRequest?) -> Unit)
    fun setAccountAuthenticatorResult(result: Bundle)
    fun setResult(result: Int)
    fun finish()

}