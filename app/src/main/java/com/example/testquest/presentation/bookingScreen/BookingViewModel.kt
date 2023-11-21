package com.example.testquest.presentation.bookingScreen

import androidx.lifecycle.ViewModel
import com.example.testquest.data.network.model.bookingModels.BookingInfoDto
import com.example.testquest.domain.useCases.GetBookingInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookingViewModel @Inject constructor(
    private val getBookingInfoUseCase: GetBookingInfoUseCase
): ViewModel() {

    private val _bookingInfo = MutableStateFlow<BookingInfoDto?>(null)
    val bookingInfo: StateFlow<BookingInfoDto?> = _bookingInfo

    init {
        getBookingInfo()
    }

    private fun getBookingInfo() {
        getBookingInfoUseCase
    }

}