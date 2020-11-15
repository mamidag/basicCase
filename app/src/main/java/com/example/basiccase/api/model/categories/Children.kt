package com.example.basiccase.api.model.categories


import android.os.Parcelable
import com.example.basiccase.api.model.common.Cover
import com.example.basiccase.api.model.common.Logo
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class Children(
    @SerialName("id")
    var id: Int,
    @SerialName("name")
    var name: String?,
    @SerialName("parent_id")
    var parentId: Int?,
    @SerialName("order")
    var order: Int?,
    @SerialName("parent_category")
    var parentCategory: ParentCategory?,
    @SerialName("logo")
    var logo: Logo?,
    @SerialName("cover")
    var cover: Cover?,
    @SerialName("children")
    var children: List<String>
) : Parcelable