package com.example.e_commerceapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EcommerceApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        //do something when we want to do
    }
}