package com.example.mystudentscheduler5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AssignmentAdapter(private val assignmentList: List<Assignment>) :
    RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.assignment_item, parent, false)
        return AssignmentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        val currentItem = assignmentList[position]
        holder.assignmentTitle.text = currentItem.title
    }

    override fun getItemCount() = assignmentList.size

    class AssignmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val assignmentTitle: TextView = itemView.findViewById(R.id.assignmentTitle)
    }
}
