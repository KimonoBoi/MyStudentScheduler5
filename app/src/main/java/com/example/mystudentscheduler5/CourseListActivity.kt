package com.example.mystudentscheduler5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mystudentscheduler5.databinding.ActivityCourseListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseListBinding
    private lateinit var courseAdapter: CourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        courseAdapter = CourseAdapter(listOf()) // Replace with actual data
        recyclerView.adapter = courseAdapter

        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener {
            // Handle adding a new course
            val intent = Intent(this, CourseDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}
