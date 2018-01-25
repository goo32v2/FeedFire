package com.goo32v2.feedfire.providers.ino.apis

import com.goo32v2.feedfire.providers.ino.models.Token
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
interface ITokenApi {

    @FormUrlEncoded
    @POST("/oauth2/token")
    fun getToken(@FieldMap params: Map<String, String>): Call<Token>

    @FormUrlEncoded
    @POST("/oauth2/token")
    fun refreshToken(@FieldMap params: Map<String, String>): Call<Token>
}