package com.ajgroup.json.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostRegisterResponse(
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null
):Parcelable