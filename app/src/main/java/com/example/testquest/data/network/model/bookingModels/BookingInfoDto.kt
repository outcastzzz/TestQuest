package com.example.testquest.data.network.model.bookingModels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "booking_info")
data class BookingInfoDto (
    @SerializedName("ID")
    @Expose
    @PrimaryKey
    val id: Int,
    @SerializedName("ARRIVALCOUNTRY")
    @Expose
    val arrivalCountry: String,
    @SerializedName("DEPARTURE")
    @Expose
    val departure: String,
    @SerializedName("FUELCHARGE")
    @Expose
    val fuelCharge: Int,
    @SerializedName("RATING")
    @Expose
    val rating: Int,
    @SerializedName("HOTELADDRESS")
    @Expose
    val hotelAddress: String,
    @SerializedName("HOTELNAME")
    @Expose
    val hotelName: String,
    @SerializedName("NUMBEROFNIGHTS")
    @Expose
    val numberOfNights: Int,
    @SerializedName("NUTRITION")
    @Expose
    val nutrition: String,
    @SerializedName("RATINGNAME")
    @Expose
    val ratingName: String,
    @SerializedName("ROOM")
    @Expose
    val room: String,
    @SerializedName("SERVICECHARGE")
    @Expose
    val serviceCharge: Int,
    @SerializedName("TOURDATESTART")
    @Expose
    val tourDateStart: String,
    @SerializedName("TOURDATESTOP")
    @Expose
    val tourDateStop: String,
    @SerializedName("TOURPRICE")
    @Expose
    val tourPrice: Int
)