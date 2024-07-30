package com.example.mystudentscheduler5.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mystudentscheduler5.R
import com.example.mystudentscheduler5.data.AppDatabase
import com.example.mystudentscheduler5.data.entities.Term
import com.example.mystudentscheduler5.databinding.ActivityTermListBinding
import com.example.mystudentscheduler5.ui.adapters.TermAdapter

class TermListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermListBinding
    private lateinit var adapter: TermAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        binding.fab.setOnClickListener {
            startActivity(Intent(this, TermDetailsActivity::class.java))
        }

        loadTerms()
    }

    private fun setupRecyclerView() {
        adapter = TermAdapter { term ->
            val intent = Intent(this, TermDetailsActivity::class.java)
            intent.putExtra("termId", term.id)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadTerms() {
        val database = AppDatabase.getDatabase(this)
        val terms = database.termDao().getAllTerms()
        adapter.submitList(terms)
    }
}
