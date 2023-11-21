package com.example.testquest.data.network.model.hotelModels

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HotelInfoJsonContainer (
    @SerializedName("RAW")
    @Expose
    val json: JsonObject? = null
)