package com.goo32v2.feedlyapi.extentions

import com.squareup.moshi.Moshi
import retrofit2.Response

/**
 * @author Alexander Steblin (goo32v2)
 * @date 26.08.2017
 */
fun <T> Response<T>.error(moshi: Moshi): Error {
    val adapter = moshi.adapter(Error::class.java)
    return adapter.fromJson(this.errorBody()?.string())

}