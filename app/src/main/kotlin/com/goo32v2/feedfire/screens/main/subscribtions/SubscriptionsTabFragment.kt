package com.goo32v2.feedfire.screens.main.subscribtions

import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.goo32v2.feedfire.R
import com.goo32v2.feedfire.screens.BaseFragment
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async


/**
 * @author Alexander Steblin (goo32v2)
 * @date 20.08.2017
 */
class SubscriptionsTabFragment : BaseFragment(R.layout.fragment_subscription_tab), ISubscriptionsTabView {
    @InjectPresenter lateinit var presenter: SubscriptionsTabPresenter

    override fun onResume() {
        super.onResume()
        async(CommonPool) { presenter.getSubscriptions() }
    }

    override fun showLoading() {
        Log.i("qq", "showLoading")
    }

    override fun dismissLoading() {
        Log.i("qq", "dismissLoading")
    }
}