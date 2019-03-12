package com.devtee.appman.feature

import androidx.multidex.MultiDexApplication
import com.devtee.appman.di.ApplicationComponent
import com.devtee.appman.di.ContextModule
import com.devtee.appman.di.DaggerApplicationComponent

class AppManApplication : MultiDexApplication() {

    companion object {
        @JvmStatic
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }
}