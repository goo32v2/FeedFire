package com.goo32v2.feedfire.di.modules

import android.accounts.AccountManager
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.goo32v2.feedfire.extentions.getDefaultPrefs
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 02.04.2017
 */
@Module(includes = [(AndroidSupportInjectionModule::class), (ServiceBinds::class)])
class ApplicationModule {

    @Provides
    @Singleton
    fun providesApp(app: Application): Context = app

    @Provides
    @Singleton
    fun providesSharedPref(ctx: Context): SharedPreferences = ctx.getDefaultPrefs()

    @Provides
    @Singleton
    fun providesAccountManager(ctx: Context): AccountManager = AccountManager.get(ctx)
}