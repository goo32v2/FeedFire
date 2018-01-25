package com.goo32v2.feedfire.di.components

import android.app.Application
import com.goo32v2.feedfire.FeedFireApp
import com.goo32v2.feedfire.InoreaderAuthenticatorService
import com.goo32v2.feedfire.di.modules.ApplicationModule
import com.goo32v2.feedfire.di.modules.ScreenBuilder
import com.goo32v2.feedfire.di.modules.providers.InoApiModule
import com.goo32v2.feedfire.screens.auth.AuthPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 02.04.2017
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        InoApiModule::class,
        ScreenBuilder::class
))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun addApplication(app: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: FeedFireApp)
    fun inject(authService: InoreaderAuthenticatorService)

    fun inject(authPresenter: AuthPresenter)
}