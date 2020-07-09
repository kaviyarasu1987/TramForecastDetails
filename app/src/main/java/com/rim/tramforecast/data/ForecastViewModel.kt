package com.rim.tramforecast.data


import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableList
import android.os.Bundle


import com.rim.tramforecast.api.Busy
import com.rim.tramforecast.api.Failure
import com.rim.tramforecast.api.Success
import com.rim.tramforecast.data.BaseViewModel
import com.rim.tramforecast.data.GetForecast
import com.rim.tramforecast.data.SchedulerFactory
import io.reactivex.Observable

import javax.inject.Inject

import me.tatarka.bindingcollectionadapter2.ItemBinding
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import com.rim.tramforecast.BR
import com.rim.tramforecast.R


class ForecastViewModel @Inject  internal constructor(
private val forecastRepository:ForecastRepositoryConnector,
private val getForecast:GetForecast,
private val schedulerFactory: SchedulerFactory
): BaseViewModel() {
    val isLoading = ObservableBoolean()
    var forecast: ObservableField<ForecastResponseWrapper> = ObservableField<ForecastResponseWrapper>()
    var directions: ObservableField<DirectionResponse> = ObservableField<DirectionResponse>()
    val trams:ObservableList<TramDetails> = ObservableArrayList<TramDetails>()




init {

    getForecast(queries = forecastRepository.queries)
        .subscribeOn(schedulerFactory.ioScheduler)
        .observeOn(schedulerFactory.mainScheduler)
        .subscribe { result ->
            when (result) {
                is Busy -> isLoading.set(true)
                is Success<ForecastResponseWrapper> -> {
                    //updatePhotos(result)
                    updateForecastDetails(result)
                    isLoading.set(false)
                    //updatePhotoCount(result)
                }
                is Failure -> {
                    //onErrorLoadingPhotosRelay.accept(Unit)
                    isLoading.set(false)
                }
            }
        }


}

    fun onQueryTimeUpdate()
    {
        forecastRepository.updateForecast()

    }

    fun loadForecast() {

        forecastRepository.updateForecast()
    }

    private fun updateForecastDetails(result: Success<ForecastResponseWrapper>) {
        forecast.set(result.value)
        directions.set(result.value.DirectionList!!.get(0))
        trams.clear()
        result.value.DirectionList!!.get(0).tramList?.let { trams.addAll(it) }
    }


}