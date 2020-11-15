package com.example.basiccase.ui.collection.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.basiccase.R
import com.example.basiccase.api.model.collections.Collection
import com.example.basiccase.databinding.ItemCollectionBinding


class CollectionAdapter(
    private val collection: List<Collection>,
) :
    RecyclerView.Adapter<CollectionAdapter.CollectionHolder>() {

    override fun getItemCount() = collection.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CollectionHolder(
            DataBindingUtil.inflate<ItemCollectionBinding>
                (
                LayoutInflater.from(parent.context),
                R.layout.item_collection,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CollectionHolder, position: Int) {

        holder.recyclerviewCollectionBinding.position = position
        holder.recyclerviewCollectionBinding.datacollection = collection[position]


    }

    inner class CollectionHolder(val recyclerviewCollectionBinding: ItemCollectionBinding) :
        RecyclerView.ViewHolder(recyclerviewCollectionBinding.root) {

    }
}