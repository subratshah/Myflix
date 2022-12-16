package com.subrat.myflix.adapter

import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.subrat.myflix.model.Movie

@BindingAdapter("setImageId")
fun setImageId(card: CardView, imageId: Int) {
    card.setBackgroundResource(imageId)
}

@BindingAdapter("setMovieList")
fun setMovieList(recyclerView: RecyclerView, movieList: List<Movie>) {
    recyclerView.layoutManager =
        LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
    recyclerView.adapter = MovieAdapter(movieList)
}
