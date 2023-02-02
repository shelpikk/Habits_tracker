package com.example.habitstracker.model.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.habitstracker.model.models.Habit
import com.example.habitstracker.model.models.HabitsListener
import com.example.habitstracker.model.models.HabitsService

class HabitsListViewModel(
    private val habitsService: HabitsService
): ViewModel() {

    private val _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> = _habits

    private val listener: HabitsListener = {
        _habits.value = it
    }

    init {
        loadHabits()
    }

    override fun onCleared() {
        super.onCleared()
        habitsService.removeListener(listener)
    }

    fun loadHabits() {
        habitsService.addListener(listener)
    }

}