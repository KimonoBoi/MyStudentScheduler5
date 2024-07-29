package com.example.mystudentscheduler5

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AssignmentDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "assignments.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_ASSIGNMENTS = "assignments"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_START_DATE = "start_date"
        private const val COLUMN_END_DATE = "end_date"
        private const val COLUMN_MEMO = "memo"
        private const val COLUMN_NOTIFICATION = "notification"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_ASSIGNMENTS ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_TITLE TEXT,"
                + "$COLUMN_START_DATE TEXT,"
                + "$COLUMN_END_DATE TEXT,"
                + "$COLUMN_MEMO TEXT,"
                + "$COLUMN_NOTIFICATION INTEGER)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ASSIGNMENTS")
        onCreate(db)
    }

    fun addAssignment(assignment: Assignment) {
        val values = ContentValues()
        values.put(COLUMN_TITLE, assignment.title)
        values.put(COLUMN_START_DATE, assignment.startDate)
        values.put(COLUMN_END_DATE, assignment.endDate)
        values.put(COLUMN_MEMO, assignment.memo)
        values.put(COLUMN_NOTIFICATION, assignment.notification)

        val db = this.writableDatabase
        db.insert(TABLE_ASSIGNMENTS, null, values)
        db.close()
    }

    fun getAllAssignments(): List<Assignment> {
        val assignments = mutableListOf<Assignment>()
        val query = "SELECT * FROM $TABLE_ASSIGNMENTS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val assignment = Assignment(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_START_DATE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_END_DATE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MEMO)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_NOTIFICATION)) == 1
                )
                assignments.add(assignment)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return assignments
    }
}
