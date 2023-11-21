package com.example.testquest.di

import android.app.Application
import com.example.testquest.data.database.AppDatabase
import com.example.testquest.data.database.bookingDao.BookingInfoDao
import com.example.testquest.data.database.hotelDao.HotelInfoDao
import com.example.testquest.data.database.roomDao.RoomInfoDao
import com.example.testquest.data.mapper.RoomsMapper
import com.example.testquest.data.network.api.ApiFactory
import com.example.testquest.data.network.api.ApiService
import com.example.testquest.data.repository.AppRepositoryImpl
import com.example.testquest.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindAppRepository(impl: AppRepositoryImpl): AppRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideHotelInfoDao(
            application: Application
        ): HotelInfoDao {
            return AppDatabase.getInstance(application).hotelInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideBookingInfoDao(
            application: Application
        ): BookingInfoDao {
            return AppDatabase.getInstance(application).bookingInfoDao()
        }


        @Provides
        @ApplicationScope
        fun provideRoomsInfoDao(
            application: Application
        ): RoomInfoDao {
            return AppDatabase.getInstance(application).roomInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

    }

}