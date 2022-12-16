package com.subrat.myflix.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.subrat.myflix.BR
import com.subrat.myflix.databinding.ItemMovieBinding
import com.subrat.myflix.model.Movie

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) =
        holder.bind(movieList[position])

    override fun getItemCount(): Int = movieList.size

    class MovieHolder(private val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(
        viewDataBinding.root
    ) {
        fun <T> bind(viewModel: T) {
            viewDataBinding.setVariable(BR.viewModel, viewModel)
            viewDataBinding.executePendingBindings()
        }
    }
}
