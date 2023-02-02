package com.example.habitstracker.model.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.habitstracker.databinding.FragmentHabitsSettingsBinding
import com.example.habitstracker.model.models.Habit

class HabitSettingsFragment : Fragment() {

    private lateinit var binding: FragmentHabitsSettingsBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHabitsSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val habit = arguments?.getSerializable(HABIT_KEY) as? Habit

        habit?.let {
            binding.habitsDescription.text = habit.description
        }

    }


    companion object {

        private const val HABIT_KEY = "HABIT_KEY"


        fun createSettingFragment(habit: Habit): HabitSettingsFragment {
            return HabitSettingsFragment().also {
                it.arguments = Bundle().apply {
                   putSerializable(HABIT_KEY, habit)
                }
            }
        }
    }
}