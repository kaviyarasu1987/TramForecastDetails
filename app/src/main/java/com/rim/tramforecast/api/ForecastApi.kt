package com.rim.tramforecast.api



import com.rim.tramforecast.data.ForecastResponseWrapper
import io.reactivex.Single
import retrofit2.http.Query

import retrofit2.http.GET


internal const val defaultAction = "forecast"
internal const val defaultEncrypt = "false"

internal interface ForecastAPI {
    @GET("xml/get.ashx")
    fun getCurrentForecast(
        @Query("action") action: String=defaultAction,
        @Query("stop") stop: String,
        @Query("encrypt") encrypt:String=defaultEncrypt
    ): Single<ForecastResponseWrapper>


}
