package com.example.testquest.data.database.hotelDao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface HotelInfoDao {
    @Query("SELECT * FROM hotel_info")
    fun getHotel(): LiveData<HotelInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHotel(hotelsInfo: HotelInfoDbModel)
}