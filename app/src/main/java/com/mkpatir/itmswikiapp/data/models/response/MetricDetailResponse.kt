package com.mkpatir.itmswikiapp.data.models.response

import com.google.gson.annotations.SerializedName

data class MetricDetailResponse(
    @SerializedName("goal") var goal: String = "",
    @SerializedName("id") var id: String = "",
    @SerializedName("measurementPeriod") var measurementPeriod: String = "",
    @SerializedName("measurementType") var measurementType: String = "",
    @SerializedName("name") var name: String = ""
)