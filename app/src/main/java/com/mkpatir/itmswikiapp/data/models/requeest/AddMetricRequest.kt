package com.mkpatir.itmswikiapp.data.models.requeest

import com.google.gson.annotations.SerializedName

data class AddMetricRequest(
    @SerializedName("goal") var goal: String = "",
    @SerializedName("measurementPeriod") var measurementPeriod: String = "",
    @SerializedName("measurementType") var measurementType: String = "",
    @SerializedName("name") var name: String = ""
)