package com.rim.tramforecast.view


import com.rim.tramforecast.data.SchedulerFactoryModule
import com.rim.tramforecast.data.ForecastRepository
import com.rim.tramforecast.data.ForecastRepositoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    AndroidBindingModule::class,
    ForecastAppModule::class,
    ForecastRepositoryModule::class,
    SchedulerFactoryModule::class


))
interface ForecastComponent: AndroidInjector<Application> {

    @Component.Builder
    abstract  class Builder:AndroidInjector.Builder<Application>();

}