package com.example.testquest.data.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.testquest.data.database.bookingDao.BookingInfoDao
import com.example.testquest.data.database.hotelDao.HotelInfoDao
import com.example.testquest.data.database.roomDao.RoomInfoDao
import com.example.testquest.data.mapper.BookingMapper
import com.example.testquest.data.mapper.HotelMapper
import com.example.testquest.data.mapper.RoomsMapper
import com.example.testquest.data.network.api.ApiService
import com.example.testquest.domain.entity.Hotel
import kotlinx.coroutines.delay
import java.lang.IllegalStateException
import javax.inject.Inject

class RefreshDataWorker(
    context: Context,
    workerParameters: WorkerParameters,
    private val apiService: ApiService,
    private val hMapper: HotelMapper,
    private val bMapper: BookingMapper,
    private val rMapper: RoomsMapper,
    private val hotelInfoDao: HotelInfoDao,
    private val bookingInfoDao: BookingInfoDao,
    private val roomsInfoDao: RoomInfoDao,
): CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val hotelInfo = apiService.getHotelInfo()
                val hotelDbModel = hotelInfo.let { hMapper.mapHotelDtoToHotelDbModel(it) }
                hotelInfoDao.insertHotel(hotelDbModel)

                val bookingInfo = apiService.getPaymentInfo()
                val bookingDbModel = bookingInfo.let { bMapper.mapBookingDtoToBookingDbModel(it) }
                bookingInfoDao.insert(bookingDbModel)

                val jsonContainer = apiService.getRoomsInfo()
                val roomsInfoDtoList = rMapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = roomsInfoDtoList.map { rMapper.mapRoomDtoToRoomDbModel(it) }
                roomsInfoDao.insertRooms(dbModelList)
            } catch (e: Exception) {
                Log.e("WorkerException", "${e.message}")
            }
            delay(1000)
        }
    }

    companion object {
        const val NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }

    class Factory @Inject constructor(
        private val apiService: ApiService,
        private val hMapper: HotelMapper,
        private val bMapper: BookingMapper,
        private val rMapper: RoomsMapper,
        private val hotelInfoDao: HotelInfoDao,
        private val bookingInfoDao: BookingInfoDao,
        private val roomsInfoDao: RoomInfoDao,
    ): ChildWorkerFactory {
        override fun create(
            context: Context,
            workerParameters: WorkerParameters
        ): ListenableWorker {
            return RefreshDataWorker(
                context,
                workerParameters,
                apiService,
                hMapper,
                bMapper,
                rMapper,
                hotelInfoDao,
                bookingInfoDao,
                roomsInfoDao,
            )
        }
    }

}