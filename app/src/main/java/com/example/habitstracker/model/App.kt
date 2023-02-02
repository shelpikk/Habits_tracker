package com.example.habitstracker.model

import android.app.Application
import com.example.habitstracker.model.models.HabitsService

class App: Application() {
    val habitsService = HabitsService()
}