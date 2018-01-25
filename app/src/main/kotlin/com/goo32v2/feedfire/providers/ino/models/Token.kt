package com.goo32v2.feedfire.providers.ino.models

import com.squareup.moshi.Json

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
data class Token(
        @Json(name = "access_token") val accessToken: String,
        @Json(name = "expires_in") val expiresIn: Int,
        @Json(name = "token_type") val tokenType: String,
        @Json(name = "scope") val scope: String,
        @Json(name = "refresh_token") val refreshToken: String
)