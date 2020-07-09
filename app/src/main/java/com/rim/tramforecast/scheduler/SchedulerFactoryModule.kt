package com.rim.tramforecast.data

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SchedulerFactoryModule {
  @Provides
  @Singleton
  fun schedulerFactory(): SchedulerFactory = SchedulerFactoryImpl()
}
