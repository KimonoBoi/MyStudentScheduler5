package com.example.mystudentscheduler5

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddAssignmentActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AssignmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_assignment)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load assignments from the database
        val assignments = loadAssignmentsFromDatabase()

        adapter = AssignmentAdapter(assignments) { assignment ->
            // When an assignment is clicked, return it to the CourseDetailsActivity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_assignment_id", assignment.id)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        recyclerView.adapter = adapter
    }

    private fun loadAssignmentsFromDatabase(): List<Assignment> {
        // Implement the logic to load assignments from the database
        return emptyList() // Placeholder
    }
}
