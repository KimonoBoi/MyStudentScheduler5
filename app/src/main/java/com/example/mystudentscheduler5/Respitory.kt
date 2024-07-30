// Repository.kt
package com.example.mystudentscheduler5.data

import android.content.Context
import androidx.work.*
import com.example.mystudentscheduler5.workers.NotificationWorker
import java.util.concurrent.TimeUnit

class Repository(private val context: Context) {

    fun scheduleNotification(title: String, message: String, delayInMillis: Long) {
        val data = workDataOf(
            "title" to title,
            "message" to message
        )

        val notificationWork = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(delayInMillis, TimeUnit.MILLISECONDS)
            .setInputData(data)
            .build()

        WorkManager.getInstance(context).enqueue(notificationWork)
    }
}
