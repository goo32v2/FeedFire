package com.goo32v2.feedfire.providers.ino.apis

import com.goo32v2.feedfire.providers.ino.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
interface IUserApi {

    @GET("/reader/api/0/user-info")
    fun getUserInfoForToken(@Header("Authorization") token: String): Call<User>

    @GET("/reader/api/0/user-info")
    fun getUserInfo(): Call<User>
}