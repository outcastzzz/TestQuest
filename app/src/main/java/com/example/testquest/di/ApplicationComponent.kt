package com.example.testquest.di

import android.app.Activity
import android.app.Application
import com.example.testquest.presentation.bookingScreen.BookingFragment
import com.example.testquest.presentation.HotelApp
import com.example.testquest.presentation.MainActivity
import com.example.testquest.presentation.hotelScreen.HotelFragment
import com.example.testquest.presentation.roomsScreen.RoomsFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: RoomsFragment)

    fun inject(fragment: BookingFragment)

    fun inject(fragment: HotelFragment)

    fun inject(application: HotelApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}