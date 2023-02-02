package com.example.habitstracker.model

import com.example.habitstracker.model.models.Habit


//in progress


interface Navigator {

    fun showSettings(habit: Habit)

    fun createNewHabit()

    fun goBack()

}