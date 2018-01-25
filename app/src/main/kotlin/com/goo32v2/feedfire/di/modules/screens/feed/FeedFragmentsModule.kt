package com.goo32v2.feedfire.di.modules.screens.feed

import com.goo32v2.feedfire.di.modules.screens.feed.DashboardTabModule
import com.goo32v2.feedfire.di.modules.screens.feed.FeedTabModule
import com.goo32v2.feedfire.di.modules.screens.feed.SubscriptionsTabModule
import com.goo32v2.feedfire.di.scopes.FragmentScope
import com.goo32v2.feedfire.screens.main.dashboard.DashboardTabFragment
import com.goo32v2.feedfire.screens.main.feed.FeedTabFragment
import com.goo32v2.feedfire.screens.main.subscribtions.SubscriptionsTabFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Alexander Steblin (goo32v2)
 * @date 24.08.2017
 */

@Module
interface FeedFragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(FeedTabModule::class))
    fun bindFeedTabFragment(): FeedTabFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(SubscriptionsTabModule::class))
    fun bindSubscriptionsTabFragment(): SubscriptionsTabFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(DashboardTabModule::class))
    fun bindDashboardTabFragment(): DashboardTabFragment
}