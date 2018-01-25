package com.goo32v2.feedfire.providers

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
enum class TokenStatus {
    VALID,
    INVALID,
    EXPIRE,
    BAD_REFRESH_TOKEN
}