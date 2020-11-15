package com.example.basiccase.ui.shops

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.basiccase.R
import com.example.basiccase.api.model.shop.PopularProduct
import com.example.basiccase.api.model.shop.Shop
import com.example.basiccase.databinding.ItemEditorShopBinding
import com.example.basiccase.databinding.ItemPopularProductBinding


class PopularProductAdapter(
    private val popularProduct: List<PopularProduct>,
) :
    RecyclerView.Adapter<PopularProductAdapter.PopularProductHolder>() {


    override fun getItemCount() = popularProduct.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PopularProductHolder(
            DataBindingUtil.inflate<ItemPopularProductBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.item_popular_product,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PopularProductHolder, position: Int) {

        holder.recyclerviewPopularProductBinding.position = position
        holder.recyclerviewPopularProductBinding.datapopularproduct = popularProduct[position]






    }

    inner class PopularProductHolder(val recyclerviewPopularProductBinding: ItemPopularProductBinding) :
        RecyclerView.ViewHolder(recyclerviewPopularProductBinding.root) {

    }
}