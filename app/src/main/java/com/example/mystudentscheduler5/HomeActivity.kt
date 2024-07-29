package com.example.mystudentscheduler5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mystudentscheduler5.databinding.ActivityHomeBinding

class
HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.termButton.setOnClickListener {
            startActivity(Intent(this, TermListActivity::class.java))
        }

        binding.courseButton.setOnClickListener {
            startActivity(Intent(this, CourseListActivity::class.java))
        }

        binding.assignmentButton.setOnClickListener {
            startActivity(Intent(this, AssignmentListActivity::class.java))
        }

        binding.notificationButton.setOnClickListener {
            startActivity(Intent(this, NotificationLogActivity::class.java))
        }
    }
}
