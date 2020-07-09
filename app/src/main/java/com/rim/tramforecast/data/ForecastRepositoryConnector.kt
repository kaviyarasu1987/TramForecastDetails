package com.rim.tramforecast.data

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import java.util.*
import java.util.Calendar.*
import javax.inject.Inject

class ForecastRepositoryConnector @Inject internal constructor() {
    private val timeZoneTextRelay = BehaviorRelay.create<Int>()


    open val queries: Flowable<Query>
        get() = timeZoneTextRelay.map {
                when (it>=0&&it<12) {
                    true -> getAntiMeridiem
                    false -> getPostMeridiem
                }
            }.toFlowable(BackpressureStrategy.BUFFER)

    open fun updateForecast() {

        timeZoneTextRelay.accept(getInstance().get(Calendar.HOUR_OF_DAY))
    }
}