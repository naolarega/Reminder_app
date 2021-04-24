package com.naolarega.reminderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var reminderAdapter: ReminderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reminderAdapter = ReminderAdapter(mutableListOf())

        rvReminderItem.adapter = reminderAdapter
        rvReminderItem.layoutManager = LinearLayoutManager(this)

        btnAddReminder.setOnClickListener {
            val reminderTitle = etReminderTitle.text.toString()
            if(reminderTitle.isNotEmpty()){
                val reminder = Reminder(reminderTitle)
                reminderAdapter.addReminder(reminder)
                etReminderTitle.text.clear()
            }
        }

        btnRemoveReminder.setOnClickListener {
            reminderAdapter.deleteReminder()
        }
    }
}