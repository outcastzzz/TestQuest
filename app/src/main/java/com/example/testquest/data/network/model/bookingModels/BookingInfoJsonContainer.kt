package com.example.testquest.data.network.model.bookingModels

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookingInfoJsonContainer (
    @SerializedName("RAW")
    @Expose
    val json: JsonObject? = null
)