package com.subrat.myflix.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.subrat.myflix.util.CategoryTypeConverters

@Entity(tableName = "categories")
@TypeConverters(CategoryTypeConverters::class)
data class Category(
    @PrimaryKey
    val categoryName: String,
    val movieList: List<Movie>
)
