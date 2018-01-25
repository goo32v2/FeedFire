package com.goo32v2.feedfire.providers.ino.factories

import com.goo32v2.feedfire.providers.ino.apis.ITokenApi
import com.goo32v2.feedfire.providers.ino.apis.IUserApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
@Singleton
class ApiFactory @Inject constructor(private val retrofit: Retrofit) : IApiFactory {

    override fun tokenApi(): ITokenApi = retrofit.create(ITokenApi::class.java)
    override fun userApi(): IUserApi = retrofit.create(IUserApi::class.java)
}