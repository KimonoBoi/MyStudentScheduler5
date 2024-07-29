package com.example.mystudentscheduler5.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val startDate: String,
    val endDate: String,
    val status: String,
    val professorName: String,
    val professorNumber: String,
    val professorEmail: String,
    val memo: String
)
