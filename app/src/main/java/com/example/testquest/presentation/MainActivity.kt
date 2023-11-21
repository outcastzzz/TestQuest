package com.example.testquest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testquest.R

class MainActivity: AppCompatActivity() {

    private val component by lazy {
        (application as HotelApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}