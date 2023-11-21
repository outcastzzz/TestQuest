package com.example.testquest.data.database.roomDao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_list")
data class RoomInfoDbModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Int,
    val pricePer: String,
    val peculiarities: List<String>,
    val imageUrls: List<String>
)

data class RoomsInfoDbModel(
    val room: List<RoomInfoDbModel>
)