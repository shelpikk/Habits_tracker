package com.example.habitstracker.model.screens

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.habitstracker.model.App
import com.example.habitstracker.model.models.HabitsService

class ViewModelFactory(
    private val habitsService: HabitsService
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when(modelClass) {
            HabitsListViewModel::class.java -> {
                HabitsListViewModel(habitsService)
            }
            else -> {
                throw IllegalStateException("Unknown view model class")
            }
        }

        return viewModel as T
    }
}

fun Fragment.factory() = ViewModelFactory((requireContext().applicationContext as App).habitsService)