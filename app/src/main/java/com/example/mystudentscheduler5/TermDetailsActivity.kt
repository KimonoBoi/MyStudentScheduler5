package com.example.mystudentscheduler5.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mystudentscheduler5.R
import com.example.mystudentscheduler5.data.AppDatabase
import com.example.mystudentscheduler5.data.entities.Term
import com.example.mystudentscheduler5.databinding.ActivityTermDetailsBinding
import com.example.mystudentscheduler5.ui.adapters.CourseAdapter

class TermDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermDetailsBinding
    private lateinit var courseAdapter: CourseAdapter
    private var termId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        termId = intent.getIntExtra("termId", -1)

        setupRecyclerView()
        loadTermDetails()

        binding.addCourseFab.setOnClickListener {
            // Handle adding a course
        }

        binding.editTermButton.setOnClickListener {
            // Handle editing the term
        }

        binding.deleteTermButton.setOnClickListener {
            // Handle deleting the term
        }

        binding.addCourseButton.setOnClickListener {
            // Handle adding a course to the term
        }
    }

    private fun setupRecyclerView() {
        courseAdapter = CourseAdapter { course ->
            // Handle course item click
        }

        binding.coursesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.coursesRecyclerView.adapter = courseAdapter
    }

    private fun loadTermDetails() {
        termId?.let { id ->
            val database = AppDatabase.getDatabase(this)
            val termWithCourses = database.termDao().getTermWithCourses(id)

            termWithCourses?.let { term ->
                binding.termTitle.setText(term.term.title)
                binding.startDate.setText(term.term.startDate)
                binding.endDate.setText(term.term.endDate)

                courseAdapter.submitList(term.courses)
            }
        }
    }
}
