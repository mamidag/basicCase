package com.example.basiccase.ui.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.basiccase.R
import com.example.basiccase.api.model.categories.Category
import com.example.basiccase.api.model.common.Logo
import com.example.basiccase.databinding.ItemCategoryBinding



class CategoryAdapter(
    private val category: List<Category>,
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    override fun getItemCount() = category.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryHolder(
            DataBindingUtil.inflate<ItemCategoryBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.item_category,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.recyclerviewCategoryBinding.position = position
        holder.recyclerviewCategoryBinding.datacategory = category[position]
    }

    inner class CategoryHolder(val recyclerviewCategoryBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(recyclerviewCategoryBinding.root) {

    }
}