package com.example.testquest.di

import androidx.lifecycle.ViewModel
import com.example.testquest.presentation.bookingScreen.BookingViewModel
import com.example.testquest.presentation.hotelScreen.HotelViewModel
import com.example.testquest.presentation.roomsScreen.RoomsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HotelViewModel::class)
    fun bindHotelViewModel(viewModel: HotelViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RoomsViewModel::class)
    fun bindRoomsViewModel(viewModel: RoomsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BookingViewModel::class)
    fun bindBookingViewModel(viewModel: BookingViewModel): ViewModel

}