package com.goo32v2.feedfire.di.modules.providers

import com.goo32v2.feedfire.providers.ino.factories.ApiFactory
import com.goo32v2.feedfire.providers.ino.factories.IApiFactory
import dagger.Binds
import dagger.Module

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */

@Module
interface InoreaderBinds {

    @Binds
    fun bindApiFactory(apiFactory: ApiFactory): IApiFactory
}