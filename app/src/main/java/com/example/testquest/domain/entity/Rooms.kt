package com.example.testquest.domain.entity

data class Room(
    val id: Int,
    val imageUrls: List<String>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    val pricePer: String
)

data class Rooms(
    val room: List<Room>
)