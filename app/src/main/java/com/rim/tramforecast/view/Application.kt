package com.rim.tramforecast.view


import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
class Application: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerForecastComponent.builder().create(this)

    }

