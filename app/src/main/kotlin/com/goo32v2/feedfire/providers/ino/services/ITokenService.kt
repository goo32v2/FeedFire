package com.goo32v2.feedfire.providers.ino.services

import com.goo32v2.feedfire.providers.TokenStatus
import com.goo32v2.feedfire.providers.ino.models.Token

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
interface ITokenService {

    suspend fun checkToken(): TokenStatus
    suspend fun getToken(code: String): Token?
    suspend fun refreshToken(refreshToken: String): Token?
}