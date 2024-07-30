package com.example.mystudentscheduler5.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotificationLogDao {

    @Insert
    suspend fun insertLog(notificationLog: NotificationLog)

    @Query("SELECT * FROM notification_logs ORDER BY timestamp DESC")
    suspend fun getLogs(): List<NotificationLog>
}
