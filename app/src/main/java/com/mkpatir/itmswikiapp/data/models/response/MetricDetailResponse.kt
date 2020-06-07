package com.mkpatir.itmswikiapp.data.models.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MetricDetailResponse(
    @SerializedName("id") var id: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("goal") var goal: String = "",
    @SerializedName("measurementType") var measurementType: String = "",
    @SerializedName("measurementPeriod") var measurementPeriod: String = ""
): Parcelable