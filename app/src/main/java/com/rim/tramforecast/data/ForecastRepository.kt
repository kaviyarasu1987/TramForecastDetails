package com.rim.tramforecast.data

import com.rim.tramforecast.api.AsyncResult
import io.reactivex.Flowable

interface ForecastRepository {

fun getForecastDetails(stop:String,boundDetails:String): Flowable<AsyncResult<ForecastResponseWrapper>>

}