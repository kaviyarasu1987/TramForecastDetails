package com.rim.tramforecast.data

import io.reactivex.Scheduler

interface SchedulerFactory {
  val mainScheduler: Scheduler
  val ioScheduler: Scheduler
}
