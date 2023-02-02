package com.example.habitstracker.model.models

typealias HabitsListener = (List<Habit>) -> Unit

class HabitsService {

    private var habits = mutableListOf<Habit>()

    private val listeners = mutableSetOf<HabitsListener>()

    init {
        habits = (1..30).map { Habit(
            id = it,
            description = " habit"
        ) }.toMutableList()
    }


    fun getById(id: Int): Habit {
        return habits[id]
    }

    fun deleteHabit(habit: Habit) {
        val indexToDelete = habits.indexOfFirst { it.id == habit.id }
        if (indexToDelete != -1) {
            habits.removeAt(indexToDelete)
            notifyChanges()
        }
    }

    fun addListener(listener: HabitsListener) {
        listeners.add(listener)
        listener.invoke(habits)
    }

    fun removeListener(listener: HabitsListener) {
        listeners.remove(listener)
    }

    private fun notifyChanges() {
        listeners.forEach { it.invoke(habits) }
    }

}