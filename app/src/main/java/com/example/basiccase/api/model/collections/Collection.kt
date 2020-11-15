package com.example.basiccase.api.model.collections

import android.os.Parcelable
import com.example.basiccase.api.model.common.Cover
import com.example.basiccase.api.model.common.Logo
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Parcelize

data class Collection(
    @SerialName("id")
    var id: Int,
    @SerialName("title")
    var title: String,
    @SerialName("definition")
    var definition: String,
    @SerialName("start")
    var start: String,
    @SerialName("end")
    var end: String?,
    @SerialName("share_url")
    var shareUrl: String,
    @SerialName("cover")
    var cover: Cover?,
    @SerialName("logo")
    var logo: Logo?
): Parcelable