package com.example.basiccase

import android.app.Application
import com.github.ajalt.timberkt.Timber
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BasiCaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        if (true) {
            Timber.plant(Timber.DebugTree())
        }

    }
}