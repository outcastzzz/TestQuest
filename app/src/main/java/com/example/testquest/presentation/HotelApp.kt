package com.example.testquest.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.testquest.data.workers.HotelWorkerFactory
import com.example.testquest.di.DaggerApplicationComponent
import javax.inject.Inject

class HotelApp: Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HotelWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}