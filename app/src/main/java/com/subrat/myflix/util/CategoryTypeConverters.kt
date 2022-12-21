package com.subrat.myflix.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.subrat.myflix.model.Category
import com.subrat.myflix.model.Movie

class CategoryTypeConverters {

    private val gson = Gson()

    @TypeConverter
    fun fromCategory(data: Category): String? = gson.toJson(data)

    @TypeConverter
    fun toCategory(json: String?): Category? = gson.fromJson(json, Category::class.java)

    @TypeConverter
    fun fromMovie(data: List<Movie>): String? = gson.toJson(data)

    @TypeConverter
    fun toMovie(json: String?): List<Movie> = listOf(gson.fromJson(json, Movie::class.java))
}