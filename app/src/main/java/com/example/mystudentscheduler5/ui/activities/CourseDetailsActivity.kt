package com.example.mystudentscheduler5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mystudentscheduler5.databinding.ActivityCourseDetailsBinding

class CourseDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailsBinding
    private val REQUEST_CODE_ADD_ASSIGNMENT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addAssignmentButton.setOnClickListener {
            val intent = Intent(this, AddAssignmentActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_ASSIGNMENT)
        }

        // Other initialization code
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_ASSIGNMENT && resultCode == RESULT_OK) {
            val selectedAssignmentId = data?.getIntExtra("selected_assignment_id", -1)
            if (selectedAssignmentId != null && selectedAssignmentId != -1) {
                // Save the selected assignment to the database
                saveAssignmentToCourse(selectedAssignmentId)
            }
        }
    }

    private fun saveAssignmentToCourse(assignmentId: Int) {
        // Implement the logic to save the assignment to the course in the database
    }
}
