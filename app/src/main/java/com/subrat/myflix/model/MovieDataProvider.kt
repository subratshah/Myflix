package com.subrat.myflix.model

import com.subrat.myflix.R

class MovieDataProvider {

    fun getMovieList(): List<Movie> {
        val englishList: MutableList<Movie> = arrayListOf(
            Movie(R.drawable.englishmovie1),
            Movie(R.drawable.englishmovie2),
            Movie(R.drawable.englishmovie3),
            Movie(R.drawable.englishmovie4),
            Movie(R.drawable.englishmovie5),
            Movie(R.drawable.englishmovie6)
        )

        return englishList
    }
}
