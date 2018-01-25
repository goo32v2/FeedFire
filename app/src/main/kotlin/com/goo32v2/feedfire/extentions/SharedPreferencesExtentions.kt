package com.goo32v2.feedfire.extentions

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * @author Alexander Steblin (goo32v2)
 * @date 09.08.2017
 */

inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}

fun SharedPreferences.getStringWithDefVal(key: String) : String = getString(key, "")

fun SharedPreferences.Editor.set(pair: Pair<String, String>): SharedPreferences.Editor =
        if (pair.second != "") putString(pair.first, pair.second) else this

fun Context.getDefaultPrefs(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
