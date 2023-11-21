package com.example.testquest.domain.useCases

import com.example.testquest.data.network.model.roomModels.RoomsInfoDto
import com.example.testquest.domain.repository.AppRepository
import javax.inject.Inject

class GetListOfRoomsUseCase @Inject constructor(
    private val repository: AppRepository
) {

    operator fun invoke() = repository.getRoomsInfo()

}