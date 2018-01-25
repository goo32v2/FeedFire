package com.goo32v2.feedfire.screens.main.feed

import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.goo32v2.feedfire.R
import com.goo32v2.feedfire.screens.BaseFragment
import com.goo32v2.feedfire.facades.IAccountFacade
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import javax.inject.Inject


/**
 * @author Alexander Steblin (goo32v2)
 * @date 20.08.2017
 */
class FeedTabFragment: BaseFragment(R.layout.fragment_feed_tab), IFeedTabView {
    @InjectPresenter lateinit var presenter: FeedTabPresenter
    @Inject lateinit var accountFacade: IAccountFacade

    override fun onResume() {
        super.onResume()
        async(CommonPool) { presenter.getEntries() }
        accountFacade.getLocalTokenAndRefreshIfNeeded()
    }

    override fun showLoading() {
        Log.i("qq", "showLoading")
    }

    override fun dismissLoading() {
        Log.i("qq", "dismissLoading")
    }
}