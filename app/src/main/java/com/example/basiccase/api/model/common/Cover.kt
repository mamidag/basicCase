package com.example.basiccase.api.model.common


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class Cover(
    @SerialName("width")
    var width: Int,
    @SerialName("height")
    var height: Int,
    @SerialName("url")
    var url: String,
    @SerialName("medium")
    var medium: Medium?,
    @SerialName("thumbnail")
    var thumbnail: Thumbnail?
): Parcelable