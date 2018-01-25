package com.goo32v2.feedfire.providers.ino.interceptors

import android.content.SharedPreferences
import com.goo32v2.feedfire.extentions.getStringWithDefVal
import com.goo32v2.feedfire.facades.impl.AccountFacade
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */

@Singleton
class InoAuthInterceptor @Inject constructor(private val sharedPreferences: SharedPreferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {
        val newRequest = chain!!.request().newBuilder()
        val token = sharedPreferences.getStringWithDefVal(AccountFacade.ACCESS_TOKEN)
        val expireInDate = sharedPreferences.getStringWithDefVal(AccountFacade.EXPIRES_IN).toLongOrNull()
        if (expireInDate != null && System.currentTimeMillis() < expireInDate && token.isNotEmpty()) {
            newRequest.addHeader("Authorization", "Bearer $token")
        }
        newRequest.addHeader("Content-Type", "application/json")
        return chain.proceed(newRequest.build())
    }
}