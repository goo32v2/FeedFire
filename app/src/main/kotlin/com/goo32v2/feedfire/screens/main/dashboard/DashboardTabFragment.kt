package com.goo32v2.feedfire.screens.main.dashboard

import com.arellomobile.mvp.presenter.InjectPresenter
import com.goo32v2.feedfire.R
import com.goo32v2.feedfire.screens.BaseFragment


/**
 * @author Alexander Steblin (goo32v2)
 * @date 20.08.2017
 */
class DashboardTabFragment : BaseFragment(R.layout.fragment_dashboard_tab), IDashboardTabView {
    @InjectPresenter lateinit var presenter: DashboardTabPresenter

    override fun onResume() {
        super.onResume()
        presenter.doSomething()
    }

}