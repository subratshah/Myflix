package com.subrat.myflix.service

import FlixterResponse
import retrofit2.http.GET

interface FlixterService {

    @GET("movies/get-upcoming/")
    suspend fun getUpcoming(): FlixterResponse

    companion object {
        const val BASE_URL = "https://flixster.p.rapidapi.com/"
        const val KEY = "08aa8a2995msh3494129b67c7601p1d69bdjsn3599b96f027b"
        const val HOST = "flixster.p.rapidapi.com"
    }
}
