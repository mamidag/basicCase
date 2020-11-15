package com.example.basiccase.api.model.common

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Parcelize

data class Thumbnail(
    @SerialName("width")
    var width: Int,
    @SerialName("height")
    var height: Int,
    @SerialName("url")
    var url: String
):Parcelable