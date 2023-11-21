package com.example.testquest.data.network.model.hotelModels

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "hotel_info")
data class HotelInfoDto(
    @Embedded
    @SerializedName("ABOUTHOTEL")
    @Expose
    val aboutHotel: AboutTheHotelEntity,
    @SerializedName("ADDRESS")
    @Expose
    val address: String,
    @PrimaryKey
    @SerializedName("ID")
    @Expose
    val id: Int,
    @SerializedName("IMAGEURLS")
    @Expose
    val imageUrls: List<String>,
    @SerializedName("MINIMALPRICE")
    @Expose
    val minimalPrice: Int,
    @SerializedName("NAME")
    @Expose
    val name: String,
    @SerializedName("PRICEFORIT")
    @Expose
    val priceForIt: String,
    @SerializedName("RATING")
    @Expose
    val rating: Int,
    @SerializedName("RATINGNAME")
    @Expose
    val ratingName: String
)

data class AboutTheHotelEntity(
    @SerializedName("DESCRIPTION")
    @Expose
    val description: String,
    @SerializedName("PECULIARITIES")
    @Expose
    val peculiarities: List<String>
)