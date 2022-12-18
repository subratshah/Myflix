package com.subrat.myflix.model

import com.subrat.myflix.R

data class Movie(val imageUrl: String, val name: String = "")
data class MoviePreview(val imageId: Int = R.drawable.img, val name: String = "Movie")
