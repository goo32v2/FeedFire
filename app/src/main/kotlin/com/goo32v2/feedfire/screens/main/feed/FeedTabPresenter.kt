package com.goo32v2.feedfire.screens.main.feed

import com.arellomobile.mvp.InjectViewState
import com.goo32v2.feedfire.screens.BasePresenter

/**
 * @author Alexander Steblin (goo32v2)
 * @date 20.08.2017
 */

@InjectViewState
class FeedTabPresenter : BasePresenter<IFeedTabView>(), IFeedTabPresenter {

    suspend override fun getEntries() {

    }
}