package com.ajgroup.json.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("role")
    val role: String? = "admin"
) : Parcelable
