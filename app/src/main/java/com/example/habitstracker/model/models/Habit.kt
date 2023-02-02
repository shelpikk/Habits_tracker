package com.example.habitstracker.model.models

import java.io.Serializable


data class Habit(
    val id: Int,
    val description: String
): Serializable