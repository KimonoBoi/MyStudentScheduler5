package com.example.mystudentscheduler5.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notification_logs")
data class NotificationLog(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val message: String,
    val timestamp: Long
)
