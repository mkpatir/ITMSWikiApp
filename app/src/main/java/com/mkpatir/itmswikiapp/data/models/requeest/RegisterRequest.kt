package com.mkpatir.itmswikiapp.data.models.requeest

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
    @SerializedName("name") var name: String,
    @SerializedName("surname") var surname: String
)