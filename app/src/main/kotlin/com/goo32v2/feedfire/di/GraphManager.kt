package com.goo32v2.feedfire.di

import android.app.Application
import com.goo32v2.feedfire.di.components.ApplicationComponent
import com.goo32v2.feedfire.di.components.DaggerApplicationComponent

/**
 * @author Alexander Steblin (goo32v2)
 * @date 18.06.2017
 */
object GraphManager {
    lateinit var applicationGraph : ApplicationComponent

    fun buildApplicationGraph(app: Application): ApplicationComponent {
        applicationGraph = DaggerApplicationComponent.builder()
                .addApplication(app)
                .build()

        return applicationGraph
    }

}