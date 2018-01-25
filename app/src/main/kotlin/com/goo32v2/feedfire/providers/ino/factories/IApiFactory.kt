package com.goo32v2.feedfire.providers.ino.factories

import com.goo32v2.feedfire.providers.ino.apis.ITokenApi
import com.goo32v2.feedfire.providers.ino.apis.IUserApi

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.09.2017
 */
interface IApiFactory {

    fun tokenApi(): ITokenApi
    fun userApi(): IUserApi
}