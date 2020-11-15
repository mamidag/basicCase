package com.example.basiccase.ui.shops

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.basiccase.R
import com.example.basiccase.api.model.shop.Shop
import com.example.basiccase.databinding.ItemNewShopBinding

class ShopNewAdapter(
    private val newProduct: List<Shop>,
) :
    RecyclerView.Adapter<ShopNewAdapter.NewShopHolder>() {


    override fun getItemCount() = newProduct.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewShopHolder(
            DataBindingUtil.inflate<ItemNewShopBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.item_new_shop,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewShopHolder, position: Int) {

        holder.recyclerviewNewShopBinding.position = position
        holder.recyclerviewNewShopBinding.datashopnew = newProduct[position]


    }

    inner class NewShopHolder(val recyclerviewNewShopBinding: ItemNewShopBinding) :
        RecyclerView.ViewHolder(recyclerviewNewShopBinding.root) {

    }
}