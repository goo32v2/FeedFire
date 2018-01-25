package com.goo32v2.feedfire.di.modules.providers

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 26.08.2017
 */
@Module
class MoshiModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder().build()

}