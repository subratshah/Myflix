package com.subrat.myflix.model

import com.subrat.myflix.R

class MovieDataProvider {

    fun getCategoryList(): List<Category> {
        val englishList: MutableList<Movie> = arrayListOf(
            Movie(R.drawable.englishmovie1, "Interstellar"),
            Movie(R.drawable.englishmovie2, "Dark Knight"),
            Movie(R.drawable.englishmovie3, "Gravity"),
            Movie(R.drawable.englishmovie4, "Expandables"),
            Movie(R.drawable.englishmovie5, "Aquaman"),
            Movie(R.drawable.englishmovie6, "X-men")
        )

        val hindiList = arrayListOf(
            Movie(R.drawable.hindimovie1, "BigBull"),
            Movie(R.drawable.hindimovie2, "Yaara"),
            Movie(R.drawable.hindimovie3, "Atragngi Re"),
            Movie(R.drawable.hindimovie4, "Race 3"),
            Movie(R.drawable.hindimovie5, "Badla")
        )

        val tamilList = arrayListOf(
            Movie(R.drawable.tamilmovie1),
            Movie(R.drawable.tamilmovie2),
            Movie(R.drawable.tamilmovie3),
            Movie(R.drawable.tamilmovie4),
            Movie(R.drawable.tamilmovie5),
            Movie(R.drawable.tamilmovie6)
        )
        val teluguList = arrayListOf(
            Movie(R.drawable.telugumovie1),
            Movie(R.drawable.telugumovie2),
            Movie(R.drawable.telugumovie3),
            Movie(R.drawable.telugumovie4),
            Movie(R.drawable.telugumovie5)
        )

        val malayalamList = arrayListOf(
            Movie(R.drawable.malayalammovie1),
            Movie(R.drawable.malayalammovie2),
            Movie(R.drawable.malayalammovie3),
            Movie(R.drawable.malayalammovie4),
            Movie(R.drawable.malayalammovie5)
        )

        return arrayListOf(
            Category("English", englishList),
            Category("Hindi", hindiList),
            Category("Tamil", tamilList),
            Category("Telugu", teluguList),
            Category("Malayalam", malayalamList)
        )
    }
}
