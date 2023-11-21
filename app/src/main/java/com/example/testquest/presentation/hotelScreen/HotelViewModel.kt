package com.example.testquest.presentation.hotelScreen

import androidx.lifecycle.ViewModel
import com.example.testquest.domain.useCases.GetHotelInfoUseCase
import com.example.testquest.domain.useCases.LoadDataUseCase
import javax.inject.Inject

class HotelViewModel @Inject constructor(
    private val getHotelInfoUseCase: GetHotelInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
): ViewModel() {

    fun getHotelInfo() = getHotelInfoUseCase()

    init {
        loadDataUseCase
    }

}