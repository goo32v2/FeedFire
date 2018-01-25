package com.goo32v2.feedfire

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.goo32v2.feedfire.di.GraphManager
import com.goo32v2.feedfire.screens.auth.Authenticator
import javax.inject.Inject

/**
 * @author Alexander Steblin (goo32v2)
 * @date 24.09.2017
 */
class InoreaderAuthenticatorService: Service() {

    @Inject lateinit var authenticator: Authenticator

    override fun onCreate() {
        super.onCreate()
        GraphManager.applicationGraph.inject(this)
    }

    override fun onBind(intent: Intent?): IBinder = authenticator.iBinder!!
}