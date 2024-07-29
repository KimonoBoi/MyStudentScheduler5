package com.example.mystudentscheduler5

data class Assignment(
    val id: Int,
    val title: String,
    val startDate: String,
    val endDate: String,
    val memo: String,
    val notification: Boolean
)
