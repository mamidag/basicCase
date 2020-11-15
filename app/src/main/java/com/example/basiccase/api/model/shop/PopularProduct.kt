package com.example.basiccase.api.model.shop

import android.os.Parcelable
import com.example.basiccase.api.model.common.Image
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class PopularProduct(
    @SerialName("id")
    var id: Int? = 0,
    @SerialName("code")
    var code: String? = "",
    @SerialName("title")
    var title: String? = "",
    @SerialName("slug")
    var slug: String? = "",
    @SerialName("definition")
    var definition: String? = "",
    @SerialName("old_price")
    var oldPrice: Int? = 0,
    @SerialName("price")
    var price: Int = 0,
    @SerialName("stock")
    var stock: Int = 0,
    @SerialName("max_installment")
    var maxInstallment: String? = "",
    @SerialName("commission_rate")
    var commissionRate: Int? = 0,
    @SerialName("cargo_time")
    var cargoTime: Int? = 0,
    @SerialName("is_cargo_free")
    var isCargoFree: Boolean,
    @SerialName("is_new")
    var isNew: Boolean,
    @SerialName("reject_reason")
    var rejectReason: String? = "",
    @SerialName("category_id")
    var categoryId: Int? = 0,
    @SerialName("view_count")
    var viewCount: Int? = 0,
    @SerialName("difference")
    var difference: String? = "",
    @SerialName("is_editor_choice")
    var isEditorChoice: Boolean,
    @SerialName("comment_count")
    var commentCount: Int? = 0,
    @SerialName("is_owner")
    var isOwner: Boolean,
    @SerialName("is_approved")
    var isApproved: Boolean,
    @SerialName("is_active")
    var isActive: Boolean,
    @SerialName("share_url")
    var shareUrl: String? = "",
    @SerialName("is_liked")
    var isLiked: Boolean,
    @SerialName("like_count")
    var likeCount: Int,
    @SerialName("images")
    var images: List<Image>? = null,
    @SerialName("category")
    var category: Category? = null
) : Parcelable