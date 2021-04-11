package com.example.recyclerview

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityDataObject(
    @Expose @SerializedName("city_name") val cityName: String,
    @Expose @SerializedName("city_code") val cityCode: String
)