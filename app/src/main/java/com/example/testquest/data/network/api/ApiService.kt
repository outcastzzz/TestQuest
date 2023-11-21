package com.example.testquest.data.network.api

import com.example.testquest.data.network.model.bookingModels.BookingInfoDto
import com.example.testquest.data.network.model.hotelModels.HotelInfoDto
import com.example.testquest.data.network.model.roomModels.RoomInfoJsonContainerDto
import retrofit2.http.GET

interface ApiService {

    @GET("v3/d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotelInfo(): HotelInfoDto

    @GET("v3/8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRoomsInfo(): RoomInfoJsonContainerDto

    @GET("v3/63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getPaymentInfo(): BookingInfoDto

}