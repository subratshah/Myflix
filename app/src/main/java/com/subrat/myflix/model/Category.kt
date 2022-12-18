package com.subrat.myflix.model

data class Category(val category: String, val movieList: List<Movie>)
data class CategoryPreview(val category: String, val movieList: List<MoviePreview>)
