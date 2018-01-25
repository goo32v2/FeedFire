package com.goo32v2.feedfire.providers.ino.services.impl

import com.goo32v2.feedfire.BuildConfig
import com.goo32v2.feedfire.providers.TokenStatus
import com.goo32v2.feedfire.providers.ino.InoreaderClient
import com.goo32v2.feedfire.providers.ino.factories.IApiFactory
import com.goo32v2.feedfire.providers.ino.models.Token
import com.goo32v2.feedfire.providers.ino.services.ITokenService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */

@Singleton
class TokenService @Inject constructor(private val apiFactory: IApiFactory) : ITokenService {

    suspend override fun checkToken(): TokenStatus {
        val userResponse = apiFactory.userApi().getUserInfo().execute()
        if (userResponse.isSuccessful){
            return TokenStatus.VALID
        }
        return TokenStatus.INVALID
    }

    suspend override fun getToken(code: String): Token? {
        val params = buildBaseParams()
        params.put("code", code)
        params.put("grant_type", InoreaderClient.ACCESS_TOKEN_GRANT_TYPE)

        val response = apiFactory.tokenApi().getToken(params).execute()
        return if (response.isSuccessful) response.body() else null
    }

    suspend override fun refreshToken(refreshToken: String): Token? {
        val params = buildBaseParams()
        params.put("refresh_token", refreshToken)
        params.put("grant_type", InoreaderClient.REFRESH_TOKEN_GRANT_TYPE)

        val response = apiFactory.tokenApi().refreshToken(params).execute()
        return if (response.isSuccessful) response.body() else null
    }

    private fun buildBaseParams(): MutableMap<String, String> {
        val params = HashMap<String, String>()
        params.put("redirect_uri", InoreaderClient.REDIRECT_URI)
        params.put("client_id", InoreaderClient.CLIENT_ID)
        params.put("client_secret", InoreaderClient.CLIENT_SECRET)
        params.put("scope", InoreaderClient.SCOPE)
        return params
    }
}