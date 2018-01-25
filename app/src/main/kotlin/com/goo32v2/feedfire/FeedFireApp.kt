package com.goo32v2.feedfire

import android.app.Activity
import android.app.Application
import com.goo32v2.feedfire.di.GraphManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author Alexander Steblin (goo32v2)
 * @date 23.01.2017
 */

class FeedFireApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        GraphManager.buildApplicationGraph(this).inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityAndroidInjector
}
