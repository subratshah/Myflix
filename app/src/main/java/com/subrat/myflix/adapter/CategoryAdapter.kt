package com.subrat.myflix.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subrat.myflix.databinding.ItemCategoryBinding
import com.subrat.myflix.model.Category

class CategoryAdapter(private val categoryList: List<Category>) : RecyclerView.Adapter<CommonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)
        return CommonHolder(binding)
    }

    override fun onBindViewHolder(holder: CommonHolder, position: Int) = holder.bind(categoryList[position])

    override fun getItemCount(): Int = categoryList.size
}
