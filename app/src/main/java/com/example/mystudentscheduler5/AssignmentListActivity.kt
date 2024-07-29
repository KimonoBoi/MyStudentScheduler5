package com.example.mystudentscheduler5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AssignmentListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var assignmentAdapter: AssignmentAdapter
    private lateinit var assignmentList: MutableList<Assignment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ass_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Assuming you fetch the data from a database
        assignmentList = fetchAssignmentsFromDatabase()
        assignmentAdapter = AssignmentAdapter(assignmentList)
        recyclerView.adapter = assignmentAdapter

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            // Handle add assignment action
        }
    }

    private fun fetchAssignmentsFromDatabase(): MutableList<Assignment> {
        // Replace this with actual database fetching logic
        return mutableListOf()
    }
}
