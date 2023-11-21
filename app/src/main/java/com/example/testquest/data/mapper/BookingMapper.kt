package com.example.testquest.data.mapper

import com.example.testquest.data.database.bookingDao.BookingInfoDbModel
import com.example.testquest.data.network.model.bookingModels.BookingInfoDto
import com.example.testquest.domain.entity.Booking
import javax.inject.Inject

class BookingMapper @Inject constructor() {

    fun mapBookingDtoToBookingDbModel(dto: BookingInfoDto) = BookingInfoDbModel(
        id = dto.id,
        arrivalCountry = dto.arrivalCountry,
        departure = dto.departure,
        fuelCharge = dto.fuelCharge,
        rating = dto.rating,
        hotelName = dto.hotelName,
        hotelAddress = dto.hotelAddress,
        numberOfNights = dto.numberOfNights,
        nutrition = dto.nutrition,
        ratingName = dto.ratingName,
        room = dto.room,
        serviceCharge = dto.serviceCharge,
        tourDateStart = dto.tourDateStart,
        tourDateStop = dto.tourDateStop,
        tourPrice = dto.tourPrice
    )

    fun mapBookingDbModelToBookingEntity(dbModel: BookingInfoDbModel) = Booking(
        id = dbModel.id,
        arrivalCountry = dbModel.arrivalCountry,
        departure = dbModel.departure,
        fuelCharge = dbModel.fuelCharge,
        rating = dbModel.rating,
        hotelName = dbModel.hotelName,
        hotelAddress = dbModel.hotelAddress,
        numberOfNights = dbModel.numberOfNights,
        nutrition = dbModel.nutrition,
        ratingName = dbModel.ratingName,
        room = dbModel.room,
        serviceCharge = dbModel.serviceCharge,
        tourDateStart = dbModel.tourDateStart,
        tourDateStop = dbModel.tourDateStop,
        tourPrice = dbModel.tourPrice
    )

}