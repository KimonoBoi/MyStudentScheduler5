package com.example.mystudentscheduler5.data.dao

import androidx.room.*
import com.example.mystudentscheduler5.data.entities.*

@Dao
interface TermDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerm(term: Term)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTermCourseCrossRef(crossRef: TermCourseCrossRef)

    @Transaction
    @Query("SELECT * FROM Term")
    suspend fun getAllTerms(): List<Term>

    @Transaction
    @Query("SELECT * FROM Term WHERE id = :termId")
    suspend fun getTermWithCourses(termId: Int): TermWithCourses?
}
