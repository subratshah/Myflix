package com.subrat.myflix.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subrat.myflix.databinding.ItemMovieBinding
import com.subrat.myflix.model.Movie

class MovieAdapter() : RecyclerView.Adapter<CommonHolder>() {

    private val movieList = mutableListOf<Movie>()

    fun setData(list: List<Movie>) {
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return CommonHolder(binding)
    }

    override fun onBindViewHolder(holder: CommonHolder, position: Int) = holder.bind(movieList[position])

    override fun getItemCount(): Int = movieList.size
}
