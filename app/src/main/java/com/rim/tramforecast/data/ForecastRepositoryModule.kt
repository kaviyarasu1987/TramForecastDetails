package com.rim.tramforecast.data


//import android.arch.persistence.room.Room
import android.content.Context
import com.rim.tramforecast.api.ForecastAPI
import com.rim.tramforecast.data.ForecastRepository
import com.rim.tramforecast.data.ForecastRepositoryImpl

//import android.room.Room
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

import javax.inject.Singleton

@Module
class ForecastRepositoryModule {
  @Provides
  @Singleton
  fun getPhotoRepository(context: Context): ForecastRepository {


    val httpClient = OkHttpClient.Builder()
        .build()


    val api = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .baseUrl("https://luasforecasts.rpa.ie/")
        .client(httpClient)
        .build()
        .create(ForecastAPI::class.java)


    return ForecastRepositoryImpl(
        api
    )
  }
//will be in offline for future
 /* private fun createAppDatabase(context: Context): AppDatabase =
      Room.databaseBuilder<AppDatabase>(
          context,
          AppDatabase::class.java,
          "Forecast.sqlite"
      ).build()*/
}
