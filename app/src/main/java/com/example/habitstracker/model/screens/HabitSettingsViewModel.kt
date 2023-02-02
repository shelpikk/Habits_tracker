package com.example.habitstracker.model.screens


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habitstracker.model.models.Habit
import com.example.habitstracker.model.models.HabitsService

class HabitSettingsViewModel(
    private val habitService: HabitsService
): ViewModel()  {

    private val _habitsSettings = MutableLiveData<Habit>()
    val habitSettings = _habitsSettings

    fun loadHabit(habitId: Int) {
        _habitsSettings.value = habitService.getById(habitId)
    }

    fun deleteHabit() {
        val habitSettings = this.habitSettings.value ?: return
        habitService.deleteHabit(habitSettings)
    }

    fun editHabit() {

    }

}