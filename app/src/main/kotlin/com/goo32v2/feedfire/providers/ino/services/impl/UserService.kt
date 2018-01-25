package com.goo32v2.feedfire.providers.ino.services.impl

import com.goo32v2.feedfire.providers.ino.services.IUserService
import com.goo32v2.feedfire.providers.ino.factories.IApiFactory
import com.goo32v2.feedfire.providers.ino.models.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 26.09.2017
 */

@Singleton
class UserService @Inject constructor(private var apiFactory: IApiFactory): IUserService {

    suspend override fun getUserProfileForToken(token: String): User? {
        val response = apiFactory.userApi().getUserInfoForToken("Bearer " + token).execute()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend override fun getUserProfile(): User? {
        val response = apiFactory.userApi().getUserInfo().execute()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}