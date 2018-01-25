package com.goo32v2.feedfire.extentions

import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * @author Alexander Steblin (goo32v2)
 * @date 09.08.2017
 */

fun Context.startActivityByIntent(intent: Intent, flag: Int = Intent.FLAG_ACTIVITY_NEW_TASK) {
    intent.flags = flag
    startActivity(intent)
}

fun Context.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}