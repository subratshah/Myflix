package com.subrat.myflix.model

import com.subrat.myflix.R

class MovieDataProvider {

    fun getCategoryList(): List<CategoryPreview> {
        val movieList: MutableList<MoviePreview> = arrayListOf(
                MoviePreview(R.drawable.img, "Movie"),
                MoviePreview(R.drawable.img, "Movie"),
                MoviePreview(R.drawable.img, "Movie"),
                MoviePreview(R.drawable.img, "Movie"),
                MoviePreview(R.drawable.img, "Movie"),
                MoviePreview(R.drawable.img, "Movie"),
                                                              )

        return arrayListOf(
                CategoryPreview("Category", movieList),
                CategoryPreview("Category", movieList),
                CategoryPreview("Category", movieList),
                CategoryPreview("Category", movieList),
        )
    }
}
