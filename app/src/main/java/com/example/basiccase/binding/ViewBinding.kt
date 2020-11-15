package com.example.basiccase.binding


import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.basiccase.R


@BindingAdapter("dataImage")
fun setImage(imageView: AppCompatImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .timeout(15000)
        .apply {
            RequestOptions()
                .error(R.drawable.ic_launcher)
        }
        .into(imageView)
}


@BindingAdapter("dataImageAsCircle")
fun setCircleImage(imageView: AppCompatImageView, url: String?) {

    imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    Glide.with(imageView.context)
        .load(url)
        .timeout(15000)
        .apply {
            RequestOptions()
                .error(R.drawable.ic_launcher)
                .circleCrop()
        }
        .circleCrop()
        .into(imageView)
}

@BindingAdapter("colorFilter")
fun setGrayFilter(imageView: AppCompatImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .timeout(15000)
        .apply {
            RequestOptions()
                .error(R.drawable.ic_launcher)
        }
        .into(imageView)
    val colorMatrix = ColorMatrix()
    colorMatrix.setSaturation(0f)
    val filter = ColorMatrixColorFilter(colorMatrix)
    imageView.setColorFilter(filter)
}

@BindingAdapter("textFirstLetter")
fun setName(textView: TextView, name: String) {
    textView.text = name.take(1)
}