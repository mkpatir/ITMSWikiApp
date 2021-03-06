package com.mkpatir.itmswikiapp.data.models.response

import com.google.gson.annotations.SerializedName

data class MetricResponse(
    @SerializedName("id") var id: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("goal") var goal: String = ""
)