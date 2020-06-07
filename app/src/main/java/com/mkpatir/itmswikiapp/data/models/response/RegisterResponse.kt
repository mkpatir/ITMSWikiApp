package com.mkpatir.itmswikiapp.data.models.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("email") val email: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("surname") val surname: String?,
    @SerializedName("token") val token: String?
)