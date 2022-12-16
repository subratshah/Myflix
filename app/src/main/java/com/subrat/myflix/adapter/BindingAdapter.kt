package com.subrat.myflix.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.subrat.myflix.model.Category
import com.subrat.myflix.model.Movie

@BindingAdapter("setImageUrl")
fun setImageUrl(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView.context)
        .load(imageUrl)
        .into(imageView)
}

@BindingAdapter("setMovieList")
fun setMovieList(recyclerView: RecyclerView, movieList: List<Movie>) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
    recyclerView.adapter = MovieAdapter().also { it.setData(movieList) }
}

@BindingAdapter("setCategoryList")
fun setCategoryList(recyclerView: RecyclerView, categoryList: List<Category>) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
    recyclerView.adapter = CategoryAdapter(categoryList)
}
