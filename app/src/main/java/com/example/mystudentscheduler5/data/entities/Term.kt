package com.example.mystudentscheduler5.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Term(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val startDate: String,
    val endDate: String
)
