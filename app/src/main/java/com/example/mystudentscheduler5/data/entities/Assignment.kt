package com.example.mystudentscheduler5.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Assignment(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val startDate: String,
    val endDate: String,
    val memo: String
)
