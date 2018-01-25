package com.goo32v2.feedfire.extentions

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v4.app.FragmentManager as SupportFragmentManager
import android.support.v4.app.FragmentTransaction as SupportFragmentTransaction


/**
 * @author Alexander Steblin (goo32v2)
 * @date 22.08.2017
 */
inline fun FragmentManager.add(func: FragmentTransaction.() -> FragmentTransaction) {
    val transaction = this.beginTransaction()
    func(transaction).commit()
}

inline fun SupportFragmentManager.add(func: SupportFragmentTransaction.() -> SupportFragmentTransaction) {
    val transaction = this.beginTransaction()
    func(transaction).commit()
}