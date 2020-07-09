package com.rim.tramforecast.view

import com.rim.tramforecast.view.ForecastFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module
abstract class AndroidBindingModule {
  @ContributesAndroidInjector
  abstract fun getForecastFragment(): ForecastFragment


}
