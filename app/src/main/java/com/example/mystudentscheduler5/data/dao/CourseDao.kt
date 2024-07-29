package com.example.mystudentscheduler5.data.dao

import androidx.room.*
import com.example.mystudentscheduler5.data.entities.*

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: Course)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAssignment(assignment: Assignment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourseAssignmentCrossRef(crossRef: CourseAssignmentCrossRef)

    @Transaction
    @Query("SELECT * FROM Course WHERE id = :courseId")
    suspend fun getCourseWithAssignments(courseId: Int): CourseWithAssignments
}
