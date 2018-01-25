package com.goo32v2.feedfire.di.modules.screens

import com.goo32v2.feedfire.di.scopes.ActivityScope
import com.goo32v2.feedfire.screens.main.FeedActivity
import com.goo32v2.feedfire.screens.main.IFeedView
import dagger.Binds
import dagger.Module

/**
 * @author Alexander Steblin (goo32v2)
 * @date 12.08.2017
 */
@Module
interface FeedModule {

    @ActivityScope
    @Binds
    fun provideFeedView(feedActivity: FeedActivity): IFeedView
}