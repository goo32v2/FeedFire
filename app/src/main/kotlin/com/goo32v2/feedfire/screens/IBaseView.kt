package com.goo32v2.feedfire.screens

import com.arellomobile.mvp.MvpView

/**
 * @author Alexander Steblin (goo32v2)
 * @date 10.06.2017
 */
interface IBaseView: MvpView {

    fun toastError(msg: String)
    fun toastMsg(msg: String)
}