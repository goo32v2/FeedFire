@file:Suppress("UNCHECKED_CAST")

package com.goo32v2.feedfire.screens

import com.arellomobile.mvp.MvpPresenter

/**
 * @author Alexander Steblin (goo32v2)
 * @date 12.08.2017
 */
open class BasePresenter<V: IBaseView>: MvpPresenter<V>(), IPresenter
