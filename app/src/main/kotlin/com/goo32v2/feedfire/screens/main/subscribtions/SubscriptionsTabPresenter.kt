package com.goo32v2.feedfire.screens.main.subscribtions

import com.arellomobile.mvp.InjectViewState
import com.goo32v2.feedfire.screens.BasePresenter

/**
 * @author Alexander Steblin (goo32v2)
 * @date 20.08.2017
 */

@InjectViewState
class SubscriptionsTabPresenter: BasePresenter<ISubscriptionsTabView>(), ISubscriptionsTabPresenter {

    suspend override fun getSubscriptions() {

    }
}