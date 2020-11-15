package com.example.basiccase.api.model.shop


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class Category(
    @SerialName("id")
    var id: Int,
    @SerialName("name")
    var name: String,
    @SerialName("parent_id")
    var parentId: Int?,
    @SerialName("order")
    var order: Int,
    @SerialName("parent_category")
    var parentCategory: ParentCategory?
):Parcelable