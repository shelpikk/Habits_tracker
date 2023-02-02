package com.example.habitstracker.model.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.habitstracker.databinding.FragmentHabitsCreateBinding


class HabitCreateFragment: Fragment() {

    private lateinit var binding: FragmentHabitsCreateBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHabitsCreateBinding.inflate(inflater, container, false)
        return binding.root
    }
}