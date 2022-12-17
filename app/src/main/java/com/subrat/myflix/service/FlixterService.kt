package com.subrat.myflix.service

import FlixterResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface FlixterService {

    @GET("movies/get-upcoming/")
    fun getUpcoming(): Observable<FlixterResponse>
}
