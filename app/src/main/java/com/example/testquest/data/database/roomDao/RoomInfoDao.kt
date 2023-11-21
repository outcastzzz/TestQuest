package com.example.testquest.data.database.roomDao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoom(room: RoomInfoDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRooms(rooms: List<RoomInfoDbModel>)

    @Query("SELECT * FROM room_list")
    fun getAllRooms(): LiveData<List<RoomInfoDbModel>>

}