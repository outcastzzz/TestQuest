package com.example.testquest.data.database.bookingDao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookingInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookingInfo: BookingInfoDbModel)

    @Query("SELECT * FROM booking_info")
    fun getBooking(): LiveData<BookingInfoDbModel>

}