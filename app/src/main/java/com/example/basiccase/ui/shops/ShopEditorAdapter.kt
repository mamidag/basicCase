package com.example.basiccase.ui.shops

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.basiccase.R
import com.example.basiccase.api.model.shop.Shop
import com.example.basiccase.databinding.ItemEditorShopBinding
import com.example.basiccase.ui.category.adapter.CategoryAdapter


class ShopEditorAdapter(
    private val shopEditor: List<Shop>,
) :
    RecyclerView.Adapter<ShopEditorAdapter.ShopEditorHolder>() {

    lateinit var popularProductAdapter : PopularProductAdapter

    override fun getItemCount() = shopEditor.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShopEditorHolder(
            DataBindingUtil.inflate<ItemEditorShopBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.item_editor_shop,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ShopEditorHolder, position: Int) {

        holder.recyclerviewShopEditorBinding.position = position
        holder.recyclerviewShopEditorBinding.datashopeditor = shopEditor[position]

        holder.recyclerviewShopEditorBinding.rvImages.adapter=PopularProductAdapter(shopEditor[position].popularProducts!!)


    }

    inner class ShopEditorHolder(val recyclerviewShopEditorBinding: ItemEditorShopBinding) :
        RecyclerView.ViewHolder(recyclerviewShopEditorBinding.root) {

    }
}