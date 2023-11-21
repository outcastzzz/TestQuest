package com.example.testquest.data.mapper

import com.example.testquest.data.database.roomDao.RoomInfoDbModel
import com.example.testquest.data.database.roomDao.RoomsInfoDbModel
import com.example.testquest.data.network.model.roomModels.RoomInfoDto
import com.example.testquest.data.network.model.roomModels.RoomInfoJsonContainerDto
import com.example.testquest.data.network.model.roomModels.RoomsInfoDto
import com.example.testquest.domain.entity.Room
import com.example.testquest.domain.entity.Rooms
import com.google.gson.Gson
import javax.inject.Inject

class RoomsMapper @Inject constructor() {

    fun mapRoomDtoToRoomDbModel(dto: RoomInfoDto) = RoomInfoDbModel(
        id = dto.id,
        name = dto.name,
        price = dto.price,
        pricePer = dto.pricePer,
        peculiarities = dto.peculiarities,
        imageUrls = dto.imageUrls
    )

    fun mapRoomDbModelToRoomEntity(dbModel: RoomInfoDbModel) = Room(
        id = dbModel.id,
        imageUrls = dbModel.imageUrls,
        name = dbModel.name,
        peculiarities = dbModel.peculiarities,
        price = dbModel.price,
        pricePer = dbModel.pricePer
    )


    fun mapJsonContainerToListCoinInfo(jsonContainer: RoomInfoJsonContainerDto): List<RoomInfoDto> {
        val result = mutableListOf<RoomInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val roomsKeySet = jsonObject.keySet()
        for (coinKey in roomsKeySet) {
            val roomsJson = jsonObject.getAsJsonObject(coinKey)
            val roomsKeySet = roomsJson.keySet()
            for (currencyKey in roomsKeySet) {
                val roomInfo = Gson().fromJson(
                    roomsJson.getAsJsonObject(currencyKey),
                    RoomInfoDto::class.java
                )
                result.add(roomInfo)
            }
        }
        return result
    }

}