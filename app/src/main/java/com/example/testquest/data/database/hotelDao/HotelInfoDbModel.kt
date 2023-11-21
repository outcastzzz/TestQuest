package com.example.testquest.data.database.hotelDao

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hotel_info")
data class HotelInfoDbModel(

    @Embedded
    val aboutHotel: AboutTheHotelEntity,
    val address: String,
    @PrimaryKey
    val id: Int,
    val imageUrls: List<String>,
    val minimalPrice: Int,
    val name: String,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String
)

data class AboutTheHotelEntity(
    val description: String,
    val peculiarities: List<String>
)