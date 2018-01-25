package com.goo32v2.feedfire.di.modules

import com.goo32v2.feedfire.facades.IAccountFacade
import com.goo32v2.feedfire.facades.impl.AccountFacade
import com.goo32v2.feedfire.providers.ino.services.ITokenService
import com.goo32v2.feedfire.providers.ino.services.IUserService
import com.goo32v2.feedfire.providers.ino.services.impl.TokenService
import com.goo32v2.feedfire.providers.ino.services.impl.UserService
import dagger.Binds
import dagger.Module

/**
 * @author Alexander Steblin (goo32v2)
 * @date 01.10.2017
 */

@Module
interface ServiceBinds {

    @Binds
    fun bindTokenService(tokenService: TokenService): ITokenService

    @Binds
    fun bindUserService(userService: UserService): IUserService

    @Binds
    fun bindAccountFacade(accountFacade: AccountFacade): IAccountFacade
}