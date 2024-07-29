package com.example.mystudentscheduler5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AssignmentDetailsActivity : AppCompatActivity() {

    private lateinit var assignmentTitleInput: EditText
    private lateinit var assignmentStartDateInput: EditText
    private lateinit var assignmentEndDateInput: EditText
    private lateinit var assignmentMemoInput: EditText
    private lateinit var notificationCheckBox: CheckBox
    private lateinit var saveAssignmentButton: Button
    private lateinit var deleteAssignmentButton: Button
    private lateinit var shareAssignmentButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ass_details)

        assignmentTitleInput = findViewById(R.id.assignmentTitleInput)
        assignmentStartDateInput = findViewById(R.id.assignmentStartDateInput)
        assignmentEndDateInput = findViewById(R.id.assignmentEndDateInput)
        assignmentMemoInput = findViewById(R.id.assignmentMemoInput)
        notificationCheckBox = findViewById(R.id.notificationCheckBox)
        saveAssignmentButton = findViewById(R.id.saveAssignmentButton)
        deleteAssignmentButton = findViewById(R.id.deleteAssignmentButton)
        shareAssignmentButton = findViewById(R.id.shareAssignmentButton)

        saveAssignmentButton.setOnClickListener {
            saveAssignment()
        }

        deleteAssignmentButton.setOnClickListener {
            deleteAssignment()
        }

        shareAssignmentButton.setOnClickListener {
            shareAssignment()
        }
    }

    private fun saveAssignment() {
        val title = assignmentTitleInput.text.toString()
        val startDate = assignmentStartDateInput.text.toString()
        val endDate = assignmentEndDateInput.text.toString()
        val memo = assignmentMemoInput.text.toString()
        val notify = notificationCheckBox.isChecked

        // Save assignment logic here
        // Notify user about the save
        Toast.makeText(this, "Assignment Saved", Toast.LENGTH_SHORT).show()

        // Schedule notifications if required
        if (notify) {
            // Schedule notifications for start and end dates
        }
    }

    private fun deleteAssignment() {
        // Delete assignment logic here
        // Notify user about the deletion
        Toast.makeText(this, "Assignment Deleted", Toast.LENGTH_SHORT).show()
    }

    private fun shareAssignment() {
        val title = assignmentTitleInput.text.toString()
        val startDate = assignmentStartDateInput.text.toString()
        val endDate = assignmentEndDateInput.text.toString()
        val memo = assignmentMemoInput.text.toString()

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Assignment: $title\nStart Date: $startDate\nEnd Date: $endDate\nMemo: $memo")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}
