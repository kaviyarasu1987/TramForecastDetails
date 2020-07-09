package com.rim.tramforecast.data


import com.rim.tramforecast.api.*
import com.rim.tramforecast.data.*
import io.reactivex.Flowable
import javax.inject.Inject

open class GetForecast @Inject internal constructor(
    public val forecastRepository: ForecastRepository
) {


  open operator fun invoke(queries: Flowable<Query>): Flowable<AsyncResult<ForecastResponseWrapper>> =
      queries.switchMap {
          when (it) {
              is getAntiMeridiem -> forecastRepository.getForecastDetails(stopMarlborough, outbound)
              is getPostMeridiem -> forecastRepository.getForecastDetails(stopStillorgan, inbound)

        }

      }
}
