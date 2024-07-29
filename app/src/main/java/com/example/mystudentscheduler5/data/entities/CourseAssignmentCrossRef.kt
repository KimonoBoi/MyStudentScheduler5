package com.example.mystudentscheduler5.data.entities

import androidx.room.Entity

@Entity(primaryKeys = ["courseId", "assignmentId"])
data class CourseAssignmentCrossRef(
    val courseId: Int,
    val assignmentId: Int
)
