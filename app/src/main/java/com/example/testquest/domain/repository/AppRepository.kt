package com.example.testquest.domain.repository

import androidx.lifecycle.LiveData
import com.example.testquest.domain.entity.Booking
import com.example.testquest.domain.entity.Hotel
import com.example.testquest.domain.entity.Room

interface AppRepository {

    fun getBookingInfo(): LiveData<Booking>

    fun getHotelInfo(): LiveData<Hotel>

    fun getRoomsInfo(): LiveData<List<Room>>

    fun loadData()

}