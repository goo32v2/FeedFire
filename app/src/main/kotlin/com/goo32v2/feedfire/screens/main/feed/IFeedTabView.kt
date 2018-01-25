package com.goo32v2.feedfire.screens.main.feed

import com.goo32v2.feedfire.screens.IBaseView

/**
 * @author Alexander Steblin (goo32v2)
 * @date 20.08.2017
 */
interface IFeedTabView : IBaseView{

    fun showLoading()

    fun dismissLoading()
}