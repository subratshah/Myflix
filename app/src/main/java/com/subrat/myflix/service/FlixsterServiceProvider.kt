package com.subrat.myflix.service

import FlixterResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlixsterServiceProvider {

    fun getUpcoming(): Observable<FlixterResponse> {
        return createService().getUpcoming()
    }

    private fun createService(): FlixterService {
        val interceptor = Interceptor { chain ->
            val headers = chain.request()
                .headers()
                .newBuilder()
                .add("X-RapidAPI-Key", KEY)
                .add("X-RapidAPI-Host", HOST)
                .build()

            val request = chain.request()
                .newBuilder()
                .headers(headers)
                .build()

            chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FlixterService::class.java)
    }

    companion object {
        const val BASE_URL = "https://flixster.p.rapidapi.com/"
        const val KEY = "08aa8a2995msh3494129b67c7601p1d69bdjsn3599b96f027b"
        const val HOST = "flixster.p.rapidapi.com"
    }
}
