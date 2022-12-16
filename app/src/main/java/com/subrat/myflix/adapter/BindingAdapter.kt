package com.subrat.myflix.adapter

import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.subrat.myflix.model.Category
import com.subrat.myflix.model.Movie

@BindingAdapter("setImageId")
fun setImageId(imageView: ImageView, imageId: Int) {
    imageView.setImageResource(imageId)
}

@BindingAdapter("setMovieList")
fun setMovieList(recyclerView: RecyclerView, movieList: List<Movie>) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
    recyclerView.adapter = MovieAdapter(movieList)
}

@BindingAdapter("setCategoryList")
fun setCategoryList(recyclerView: RecyclerView, categoryList: List<Category>) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
    recyclerView.adapter = CategoryAdapter(categoryList)
}
