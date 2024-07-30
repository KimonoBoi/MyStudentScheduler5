// NotificationWorker.kt
package com.example.mystudentscheduler5.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.mystudentscheduler5.utils.NotificationUtils

class NotificationWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val title = inputData.getString("title") ?: return Result.failure()
        val message = inputData.getString("message") ?: return Result.failure()

        NotificationUtils.showNotification(applicationContext, title, message)

        return Result.success()
    }
}
