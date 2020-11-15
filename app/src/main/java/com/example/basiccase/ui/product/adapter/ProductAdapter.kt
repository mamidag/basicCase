package com.example.basiccase.ui.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.basiccase.R
import com.example.basiccase.api.model.products.Products
import com.example.basiccase.databinding.ItemProductBinding


class ProductAdapter(
    private val products: List<Products>,
) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductHolder(
            DataBindingUtil.inflate<ItemProductBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.item_product,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {

        holder.recyclerviewProductBinding.position = position
        holder.recyclerviewProductBinding.data = products[position]


    }

    inner class ProductHolder(val recyclerviewProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(recyclerviewProductBinding.root) {

    }
}