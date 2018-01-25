package com.goo32v2.feedfire.screens

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.goo32v2.feedfire.extentions.toast
import dagger.android.AndroidInjection

/**
 * @author Alexander Steblin (goo32v2)
 * @date 10.06.2017
 */
abstract class BaseActivity(@LayoutRes private var layout: Int) : MvpAppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

    override fun toastError(msg: String) = toast(msg, Toast.LENGTH_LONG)

    override fun toastMsg(msg: String) = toast(msg)
}