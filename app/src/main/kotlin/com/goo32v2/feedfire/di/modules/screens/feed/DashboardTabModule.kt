package com.goo32v2.feedfire.di.modules.screens.feed

import com.goo32v2.feedfire.di.scopes.FragmentScope
import com.goo32v2.feedfire.screens.main.dashboard.DashboardTabFragment
import com.goo32v2.feedfire.screens.main.dashboard.IDashboardTabView
import dagger.Binds
import dagger.Module

/**
 * @author Alexander Steblin (goo32v2)
 * @date 20.08.2017
 */

@Module
interface DashboardTabModule {

    @FragmentScope
    @Binds
    fun bindFragmentView(dashboardTabFragment: DashboardTabFragment) : IDashboardTabView
}