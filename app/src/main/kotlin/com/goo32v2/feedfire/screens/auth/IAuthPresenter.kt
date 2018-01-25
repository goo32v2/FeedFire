package com.goo32v2.feedfire.screens.auth

import com.goo32v2.feedfire.providers.ino.models.Token
import com.goo32v2.feedfire.providers.ino.models.User
import com.goo32v2.feedfire.screens.IPresenter

/**
 * @author Alexander Steblin (goo32v2)
 * @package com.goo32v2.feedlyplus.features.auth
 * @date 5/30/17
 */
interface IAuthPresenter: IPresenter
{
    fun onTokenReceived(user: User?, token: Token?)
}