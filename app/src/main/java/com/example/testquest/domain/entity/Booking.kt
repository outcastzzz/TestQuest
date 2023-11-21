package com.example.testquest.domain.entity

data class Booking(
    val arrivalCountry: String,
    val departure: String,
    val fuelCharge: Int,
    val rating: Int,
    val hotelAddress: String,
    val hotelName: String,
    val id: Int,
    val numberOfNights: Int,
    val nutrition: String,
    val ratingName: String,
    val room: String,
    val serviceCharge: Int,
    val tourDateStart: String,
    val tourDateStop: String,
    val tourPrice: Int
)