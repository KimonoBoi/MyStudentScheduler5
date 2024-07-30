@Database(entities = [Course::class, Assignment::class, Term::class, CourseAssignmentCrossRef::class, TermCourseCrossRef::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun assignmentDao(): AssignmentDao
    abstract fun termDao(): TermDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "student_scheduler_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
