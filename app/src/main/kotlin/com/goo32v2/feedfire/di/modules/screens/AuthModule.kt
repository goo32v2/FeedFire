package com.goo32v2.feedfire.di.modules.screens

import com.goo32v2.feedfire.di.scopes.ActivityScope
import com.goo32v2.feedfire.screens.auth.AuthActivity
import com.goo32v2.feedfire.screens.auth.IAuthView
import dagger.Binds
import dagger.Module

/**
 * @author Alexander Steblin (goo32v2)
 * @date 14.08.2017
 */

@Module
interface AuthModule {

    @ActivityScope
    @Binds
    fun provideMainView(authActivity: AuthActivity): IAuthView
}