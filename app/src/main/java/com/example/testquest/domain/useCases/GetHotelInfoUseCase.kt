package com.example.testquest.domain.useCases

import com.example.testquest.domain.repository.AppRepository
import javax.inject.Inject

class GetHotelInfoUseCase @Inject constructor(
    private val repository: AppRepository
) {

    operator fun invoke() = repository.getHotelInfo()
}