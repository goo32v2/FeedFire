package com.goo32v2.feedfire.di.modules

import com.goo32v2.feedfire.di.modules.screens.AuthModule
import com.goo32v2.feedfire.di.modules.screens.FeedModule
import com.goo32v2.feedfire.di.modules.screens.feed.FeedFragmentsModule
import com.goo32v2.feedfire.di.scopes.ActivityScope
import com.goo32v2.feedfire.screens.auth.AuthActivity
import com.goo32v2.feedfire.screens.main.FeedActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Alexander Steblin (goo32v2)
 * @date 15.08.2017
 */

@Module
interface ScreenBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(AuthModule::class)])
    fun bindAuthActivity(): AuthActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(FeedModule::class), (FeedFragmentsModule::class)])
    fun bindFeedActivity(): FeedActivity
}