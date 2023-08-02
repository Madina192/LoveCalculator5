package com.example.lovecalculator5

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator5.data.local.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-file")
                .allowMainThreadQueries().build()
    }
}