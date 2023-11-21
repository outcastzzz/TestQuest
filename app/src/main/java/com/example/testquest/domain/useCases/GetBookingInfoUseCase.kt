package com.example.testquest.domain.useCases

import com.example.testquest.data.network.model.bookingModels.BookingInfoDto
import com.example.testquest.domain.repository.AppRepository
import javax.inject.Inject

class GetBookingInfoUseCase @Inject constructor(
    private val repository: AppRepository
) {

    operator fun invoke() = repository.loadData()

}