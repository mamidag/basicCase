package com.example.basiccase.api.model.shop

import android.os.Parcelable
import com.example.basiccase.api.model.common.Cover
import com.example.basiccase.api.model.common.Logo
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class Shop(
    @SerialName("id")
    var id: Int,
    @SerialName("name")
    var name: String,
    @SerialName("slug")
    var slug: String,
    @SerialName("definition")
    var definition: String,
    @SerialName("name_updateable")
    var nameUpdateable: Boolean,
    @SerialName("vacation_mode")
    var vacationMode: Int,
    @SerialName("created_at")
    var createdAt: String,
    @SerialName("shop_payment_id")
    var shopPaymentId: Int,
    @SerialName("popular_products")
    var popularProducts: List<PopularProduct>?=null,
    @SerialName("product_count")
    var productCount: Int,
    @SerialName("shop_rate")
    var shopRate: Int,
    @SerialName("comment_count")
    var commentCount: Int,
    @SerialName("follower_count")
    var followerCount: Int,
    @SerialName("is_editor_choice")
    var isEditorChoice: Boolean,
    @SerialName("is_following")
    var isFollowing: Boolean,
    @SerialName("cover")
    var cover: Cover?,
    @SerialName("share_url")
    var shareUrl: String,
    @SerialName("logo")
    var logo: Logo?
): Parcelable