package com.example.csc475_pp8.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.csc475_pp8.model.EventEntity

@Database(entities = [EventEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}
