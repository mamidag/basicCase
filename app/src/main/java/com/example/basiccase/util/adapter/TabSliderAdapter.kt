package com.example.basiccase.util.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.basiccase.R
import com.example.basiccase.api.model.featured.Featured
import com.example.basiccase.util.model.TabSlider
import kotlinx.android.synthetic.main.slide_item_container.view.*

class TabSliderAdapter(private val tabSlides: List<Featured>) : RecyclerView.Adapter<TabSliderAdapter.TabSlideViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabSlideViewHolder {
        return TabSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TabSlideViewHolder, position: Int) {
        holder.bind(tabSlides[position])
    }

    override fun getItemCount(): Int = tabSlides.size



    inner class TabSlideViewHolder(view: View):RecyclerView.ViewHolder(view){


        private val txtTitle = view.findViewById<TextView>(R.id.tv_feature_text)
        private val txtCategory =  view.findViewById<TextView>(R.id.tv_subtitle)
        private val ivCover = view.findViewById<ImageView>(R.id.iv_cover)

        fun bind(tabSlider: Featured){
            txtTitle.text = tabSlider.title
            txtCategory.text = tabSlider.subTitle
            Glide.with(ivCover.context)
                .load(tabSlider.cover!!.url)
                .timeout(15000)
                .apply(
                    RequestOptions()
                        .error(R.drawable.ic_launcher)
                )
                .into(ivCover)
        }

    }

}