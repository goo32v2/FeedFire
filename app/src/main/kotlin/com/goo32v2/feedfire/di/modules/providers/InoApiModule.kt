package com.goo32v2.feedfire.di.modules.providers

import com.goo32v2.feedfire.providers.ino.InoreaderClient
import com.goo32v2.feedfire.providers.ino.interceptors.InoAuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 18.08.2017
 */

@Module(includes = arrayOf(InoreaderBinds::class, MoshiModule::class))
class InoApiModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(loggingInterceptor: HttpLoggingInterceptor,
                            authInterceptor: InoAuthInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addNetworkInterceptor(authInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .build()


    @Provides
    @Singleton
    fun provideRetrofit(okClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(InoreaderClient.BASE_URL)
            .client(okClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}