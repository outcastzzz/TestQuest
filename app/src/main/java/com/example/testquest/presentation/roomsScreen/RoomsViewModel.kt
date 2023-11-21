package com.example.testquest.presentation.roomsScreen

import androidx.lifecycle.ViewModel
import com.example.testquest.data.network.model.roomModels.RoomsInfoDto
import com.example.testquest.domain.useCases.GetListOfRoomsUseCase
import com.example.testquest.domain.useCases.LoadDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RoomsViewModel @Inject constructor(
    private val getListOfRoomsUseCase: GetListOfRoomsUseCase,
    private val loadDataUseCase: LoadDataUseCase
): ViewModel() {

    val roomsList = getListOfRoomsUseCase()

}