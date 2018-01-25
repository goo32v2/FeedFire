package com.goo32v2.feedfire.di.modules.screens.feed

import com.goo32v2.feedfire.di.scopes.FragmentScope
import com.goo32v2.feedfire.screens.main.feed.FeedTabFragment
import com.goo32v2.feedfire.screens.main.feed.IFeedTabView
import dagger.Binds
import dagger.Module

/**
 * @author Alexander Steblin (goo32v2)
 * @date 20.08.2017
 */

@Module
interface FeedTabModule {

    @FragmentScope
    @Binds
    fun bindFragmentView(feedTabFragment: FeedTabFragment) : IFeedTabView
}