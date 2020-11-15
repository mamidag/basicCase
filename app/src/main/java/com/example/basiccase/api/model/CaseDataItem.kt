package com.example.basiccase.api.model

import android.os.Parcelable
import com.example.basiccase.api.model.categories.Category
import com.example.basiccase.api.model.collections.Collection
import com.example.basiccase.api.model.featured.Featured
import com.example.basiccase.api.model.products.Products
import com.example.basiccase.api.model.shop.Shop
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class CaseDataItem(
    @SerialName("type")
    var type: String,
    @SerialName("title")
    var title: String,
    @SerialName("featured")
    var featured: List<Featured>? = null,
    @SerialName("products")
    var products: List<Products>? = null,
    @SerialName("categories")
    var categories: List<Category>? = null,
    @SerialName("collections")
    var collections: List<Collection>? = null,
    @SerialName("shops")
    var shops: List<Shop>? = null


) : Parcelable


