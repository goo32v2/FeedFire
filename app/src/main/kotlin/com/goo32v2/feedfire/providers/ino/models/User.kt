package com.goo32v2.feedfire.providers.ino.models

import com.squareup.moshi.Json

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
data class User(
        @Json(name = "userId") var userId: Long,
        @Json(name = "userName") var userName: String,
        @Json(name = "userProfileId") var userProfileId: Long,
        @Json(name = "userEmail") var userEmail: String,
        @Json(name = "isBloggerUser") var isBloggerUser: Boolean,
        @Json(name = "signupTimeSec") var signupTimeSec: Long,
        @Json(name = "isMultiLoginEnabled") var isMultiLoginEnabled: Boolean
)