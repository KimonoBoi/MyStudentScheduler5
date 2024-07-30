package com.example.mystudentscheduler5.data.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class TermWithCourses(
    @Embedded val term: Term,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(TermCourseCrossRef::class)
    )
    val courses: List<Course>
)
