package com.example.testquest.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.testquest.data.database.bookingDao.BookingInfoDao
import com.example.testquest.data.database.hotelDao.HotelInfoDao
import com.example.testquest.data.database.roomDao.RoomInfoDao
import com.example.testquest.data.mapper.BookingMapper
import com.example.testquest.data.mapper.HotelMapper
import com.example.testquest.data.mapper.RoomsMapper
import com.example.testquest.data.workers.RefreshDataWorker
import com.example.testquest.domain.entity.Booking
import com.example.testquest.domain.entity.Hotel
import com.example.testquest.domain.entity.Room
import com.example.testquest.domain.entity.Rooms
import com.example.testquest.domain.repository.AppRepository
import java.security.PrivateKey
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val application: Application,
    private val hotelInfoDao: HotelInfoDao,
    private val bookingInfoDao: BookingInfoDao,
    private val roomsInfoDao: RoomInfoDao,
    private val hMapper: HotelMapper,
    private val bMapper: BookingMapper,
    private val rMapper: RoomsMapper,
): AppRepository {

    override fun getBookingInfo(): LiveData<Booking> {
        val mediatorLiveData = MediatorLiveData<Booking>()
        mediatorLiveData.addSource(bookingInfoDao.getBooking()) {
            if (it != null) {
                val booking = bMapper.mapBookingDbModelToBookingEntity(it)
                mediatorLiveData.value = booking
            }
        }
        return mediatorLiveData
    }

    override fun getHotelInfo(): LiveData<Hotel> {
        val mediatorLiveData = MediatorLiveData<Hotel>()
        mediatorLiveData.addSource(hotelInfoDao.getHotel()) {
            if (it != null) {
                val hotel = hMapper.mapHotelDbModelToHotelEntity(it)
                mediatorLiveData.value = hotel
            }
        }
        return mediatorLiveData
    }

    override fun getRoomsInfo(): LiveData<List<Room>> {
        val mediatorLiveData = MediatorLiveData<List<Room>>()
        mediatorLiveData.addSource(roomsInfoDao.getAllRooms()) {
            it?.map {
                val rooms = rMapper.mapRoomDbModelToRoomEntity(it)
                mediatorLiveData.value = listOf(rooms)
            }
        }
        return mediatorLiveData
    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}