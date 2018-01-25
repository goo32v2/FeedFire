package com.goo32v2.feedfire.screens

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.goo32v2.feedfire.extentions.toast
import dagger.android.support.AndroidSupportInjection

/**
 * @author Alexander Steblin (goo32v2)
 * @date 17.06.2017
 */
abstract class BaseFragment(@LayoutRes private var layout: Int) : MvpAppCompatFragment(), IBaseView {

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onAttach(activity: Activity?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d(this::class.java.name, "onCreateView")
        return inflater.inflate(layout, container, false)
    }

    override fun toastError(msg: String) = activity!!.toast(msg, Toast.LENGTH_LONG)
    override fun toastMsg(msg: String) = activity!!.toast(msg)
}