package com.subrat.myflix.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.subrat.myflix.service.FlixterService
import com.subrat.myflix.service.FlixterService.Companion.BASE_URL
import com.subrat.myflix.service.FlixterService.Companion.HOST
import com.subrat.myflix.service.FlixterService.Companion.KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @[Provides Singleton]
    fun provideRetrofit(): Retrofit {
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
    }

    @[Provides Singleton]
    fun providesFlixterService(retrofit: Retrofit): FlixterService =
        retrofit.create(FlixterService::class.java)
}