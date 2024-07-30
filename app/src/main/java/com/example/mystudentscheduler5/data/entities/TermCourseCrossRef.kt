package com.example.mystudentscheduler5.data.entities

import androidx.room.Entity

@Entity(primaryKeys = ["termId", "courseId"])
data class TermCourseCrossRef(
    val termId: Int,
    val courseId: Int
)
