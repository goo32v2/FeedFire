package com.goo32v2.feedfire.screens.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.goo32v2.feedfire.R
import com.goo32v2.feedfire.extentions.add
import com.goo32v2.feedfire.screens.BaseActivity
import com.goo32v2.feedfire.screens.main.dashboard.DashboardTabFragment
import com.goo32v2.feedfire.screens.main.feed.FeedTabFragment
import com.goo32v2.feedfire.screens.main.subscribtions.SubscriptionsTabFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_feed.*
import javax.inject.Inject

class FeedActivity : BaseActivity(R.layout.activity_feed), IFeedView, HasSupportFragmentInjector,
        BottomNavigationView.OnNavigationItemSelectedListener{

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @InjectPresenter lateinit var feedPresenter : FeedPresenter

    private lateinit var feedTabFragment: FeedTabFragment
    private lateinit var subscriptionsTabFragment: SubscriptionsTabFragment
    private lateinit var dashboardTabFragment: DashboardTabFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottom_navigation_view.setOnNavigationItemSelectedListener(this)
        feedTabFragment = FeedTabFragment()
        subscriptionsTabFragment = SubscriptionsTabFragment()
        dashboardTabFragment = DashboardTabFragment()

        setFragment(feedTabFragment as Fragment)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_feed -> { setFragment(feedTabFragment) }
            R.id.action_dashboard -> { setFragment(dashboardTabFragment) }
            R.id.action_subscription -> { setFragment(subscriptionsTabFragment) }
        }
        return true
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    private fun setFragment(fragment: Fragment) =
            supportFragmentManager.add {
                replace(R.id.container, fragment)
                addToBackStack(fragment::class.java.name)
            }
}
