package com.example.testquest.data.mapper

import com.example.testquest.data.database.bookingDao.BookingInfoDbModel
import com.example.testquest.data.database.hotelDao.AboutTheHotelEntity
import com.example.testquest.data.database.hotelDao.HotelInfoDbModel
import com.example.testquest.data.database.roomDao.RoomInfoDbModel
import com.example.testquest.data.network.model.bookingModels.BookingInfoDto
import com.example.testquest.data.network.model.bookingModels.BookingInfoJsonContainer
import com.example.testquest.data.network.model.hotelModels.HotelInfoDto
import com.example.testquest.data.network.model.hotelModels.HotelInfoJsonContainer
import com.example.testquest.data.network.model.roomModels.RoomInfoContainerDto
import com.example.testquest.domain.entity.Booking
import com.example.testquest.domain.entity.Hotel
import com.example.testquest.domain.entity.Rooms
import com.google.gson.Gson
import retrofit2.Response
import javax.inject.Inject

class HotelMapper @Inject constructor() {

    fun mapHotelDtoToHotelDbModel(dto: HotelInfoDto) = HotelInfoDbModel(
        aboutHotel = AboutTheHotelEntity(
            description = dto.aboutHotel.description,
            peculiarities = dto.aboutHotel.peculiarities
        ),
        address = dto.address,
        id = dto.id,
        imageUrls = dto.imageUrls,
        minimalPrice = dto.minimalPrice,
        name = dto.name,
        priceForIt = dto.priceForIt,
        rating = dto.rating,
        ratingName = dto.ratingName
    )

    fun mapHotelDbModelToHotelEntity(dbModel: HotelInfoDbModel) = Hotel(
        aboutHotel = com.example.testquest.domain.entity.AboutTheHotelEntity(
            description = dbModel.aboutHotel.description,
            peculiarities = dbModel.aboutHotel.peculiarities,
        ),
        address = dbModel.address,
        id = dbModel.id,
        imageUrls = dbModel.imageUrls,
        minimalPrice = dbModel.minimalPrice,
        name = dbModel.name,
        priceForIt = dbModel.priceForIt,
        rating = dbModel.rating,
        ratingName = dbModel.ratingName
    )

}