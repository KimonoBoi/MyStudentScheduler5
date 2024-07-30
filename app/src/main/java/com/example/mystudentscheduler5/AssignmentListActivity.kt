package com.example.mystudentscheduler5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mystudentscheduler5.data.Repository
import com.example.mystudentscheduler5.data.entities.Assignment
import com.example.mystudentscheduler5.utils.NotificationUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class AssignmentListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var assignmentAdapter: AssignmentAdapter
    private lateinit var assignmentList: MutableList<Assignment>
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ass_list)

        NotificationUtils.createNotificationChannel(this)
        repository = Repository(this)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Assuming you fetch the data from a database
        assignmentList = fetchAssignmentsFromDatabase()
        assignmentAdapter = AssignmentAdapter(assignmentList)
        recyclerView.adapter = assignmentAdapter

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            // Handle add assignment action
            // Example: schedule a notification for an assignment's start date
            val assignment = Assignment(
                id = 0,
                title = "New Assignment",
                startDate = "2023-12-31 09:00:00",
                endDate = "2024-01-01 09:00:00",
                memo = "Complete the new assignment"
            )
            scheduleAssignmentNotifications(assignment)
        }
    }

    private fun fetchAssignmentsFromDatabase(): MutableList<Assignment> {
        // Replace this with actual database fetching logic
        return mutableListOf()
    }

    private fun scheduleAssignmentNotifications(assignment: Assignment) {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val startDate = format.parse(assignment.startDate)?.time ?: return
        val endDate = format.parse(assignment.endDate)?.time ?: return

        val currentTime = System.currentTimeMillis()
        if (startDate > currentTime) {
            repository.scheduleNotification(
                title = "Assignment Start",
                message = "Assignment '${assignment.title}' is starting",
                delayInMillis = startDate - currentTime
            )
        }
        if (endDate > currentTime) {
            repository.scheduleNotification(
                title = "Assignment End",
                message = "Assignment '${assignment.title}' is ending",
                delayInMillis = endDate - currentTime
            )
        }
    }
}
