package com.example.lovecalculator5.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator5.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun loveDao() : LoveDao
}