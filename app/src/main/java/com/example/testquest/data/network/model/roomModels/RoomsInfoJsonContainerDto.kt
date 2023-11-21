package com.example.testquest.data.network.model.roomModels

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RoomInfoJsonContainerDto(
    @SerializedName("RAW")
    @Expose
    val json: JsonObject? = null
)