package com.example.testquest.di

import com.example.testquest.data.mapper.BookingMapper
import com.example.testquest.data.mapper.HotelMapper
import com.example.testquest.data.mapper.RoomsMapper
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface MapperModule {

    @Provides
    @ApplicationScope
    fun provideHotelMapper(): HotelMapper {
        return HotelMapper()
    }

    @Provides
    @ApplicationScope
    fun provideRoomsMapper(): RoomsMapper {
        return RoomsMapper()
    }

    @Provides
    @ApplicationScope
    fun provideBookingMapper(): BookingMapper {
        return BookingMapper()
    }

}