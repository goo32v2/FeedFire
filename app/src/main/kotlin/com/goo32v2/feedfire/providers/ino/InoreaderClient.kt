package com.goo32v2.feedfire.providers.ino

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
class InoreaderClient {
    companion object {

        val CLIENT_ID: String = "1000000566"
        val CLIENT_SECRET: String = "YMJPA4hbuNiWCtOs79QzLoQ4BrqQfqZ5"

        val BASE_URL: String = "https://www.inoreader.com"
        val ACCESS_TOKEN_GRANT_TYPE: String = "authorization_code"
        val REFRESH_TOKEN_GRANT_TYPE: String = "refresh_token"
        val SCOPE: String = "read"
        val REDIRECT_URI: String = "https://feedfire.oauth"

        fun buildOathUserUrl(): String = "$BASE_URL/oauth2/auth?" +
                "client_id=$CLIENT_ID&" +
                "redirect_uri=$REDIRECT_URI&" +
                "response_type=code&" +
                "scope=$SCOPE&" +
                "state=${System.currentTimeMillis()}"
    }


}