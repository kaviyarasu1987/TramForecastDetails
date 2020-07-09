package com.rim.tramforecast.view

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
class ForecastAppModule {
    @Provides
    fun getResouces(app:Application): Resources = app.resources

    @Provides
    fun getContext(app:Application): Context = app
}