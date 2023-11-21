package com.example.testquest.domain.entity

data class Hotel(
    val aboutHotel: AboutTheHotelEntity,
    val address: String,
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