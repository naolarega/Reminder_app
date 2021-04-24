package com.naolarega.reminderapp

data class Reminder(
    val title: String,
    var isChecked: Boolean = false
)