package com.example.testquest.data.database.bookingDao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booking_info")
data class BookingInfoDbModel(
    @PrimaryKey
    val id: Int,
    val arrivalCountry: String,
    val departure: String,
    val fuelCharge: Int,
    val rating: Int,
    val hotelAddress: String,
    val hotelName: String,
    val numberOfNights: Int,
    val nutrition: String,
    val ratingName: String,
    val room: String,
    val serviceCharge: Int,
    val tourDateStart: String,
    val tourDateStop: String,
    val tourPrice: Int
)