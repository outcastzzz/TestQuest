package com.example.testquest.data.network.model.roomModels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "room_list")
data class RoomInfoDto(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("price")
    @Expose
    val price: Int,
    @SerializedName("price_per")
    @Expose
    val pricePer: String,
    @SerializedName("peculiarities")
    @Expose
    val peculiarities: List<String>,
    @SerializedName("image_urls")
    @Expose
    val imageUrls: List<String>
)

data class RoomsInfoDto(
    @SerializedName("rooms")
    @Expose
    val rooms: List<RoomInfoDto>
)