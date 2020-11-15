package com.example.basiccase.api.model.featured


import android.os.Parcelable
import com.example.basiccase.api.model.common.Cover
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Featured(
    @SerialName("id")
    var id: Int,
    @SerialName("type")
    var type: String,
    @SerialName("cover")
    var cover: Cover?,
    @SerialName("title")
    var title: String,
    @SerialName("sub_title")
    var subTitle: String
):Parcelable