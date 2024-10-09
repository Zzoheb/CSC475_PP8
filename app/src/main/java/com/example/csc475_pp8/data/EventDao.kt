package com.example.csc475_pp8.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.csc475_pp8.model.EventEntity

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(event: EventEntity)

    @Update
    fun updateEvent(event: EventEntity)

    @Delete
    fun deleteEvent(event: EventEntity)

    @Query("SELECT * FROM events")
    fun getAllEvents(): LiveData<List<EventEntity>>
}
