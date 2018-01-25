package com.goo32v2.feedfire.providers.ino.services

import com.goo32v2.feedfire.providers.ino.models.User

/**
 * @author Alexander Steblin (goo32v2)
 * @date 26.09.2017
 */
interface IUserService {

    suspend fun getUserProfile(): User?
    suspend fun getUserProfileForToken(token: String): User?
}