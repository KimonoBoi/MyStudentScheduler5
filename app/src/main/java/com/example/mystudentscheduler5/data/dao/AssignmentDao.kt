package com.example.mystudentscheduler5.data.dao

import androidx.room.*
import com.example.mystudentscheduler5.data.entities.Assignment

@Dao
interface AssignmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAssignment(assignment: Assignment)

    @Query("SELECT * FROM Assignment")
    suspend fun getAllAssignments(): List<Assignment>
}
