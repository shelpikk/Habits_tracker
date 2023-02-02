package com.example.habitstracker.model.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habitstracker.R
import com.example.habitstracker.databinding.FragmentHabitsListBinding
import com.example.habitstracker.model.HabitActionListener
import com.example.habitstracker.model.HabitsAdapter
import com.example.habitstracker.model.MainActivity
import com.example.habitstracker.model.models.Habit
import com.example.habitstracker.model.models.HabitsService

class HabitListFragment: Fragment() {

    private lateinit var binding: FragmentHabitsListBinding
    private lateinit var adapter: HabitsAdapter

    private val habitsService: HabitsService = HabitsService()
    private val viewModel: HabitsListViewModel by viewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHabitsListBinding.inflate(inflater, container, false)
        adapter = HabitsAdapter(requireActivity() as HabitActionListener)

        viewModel.habits.observe(viewLifecycleOwner, Observer {
            adapter.habits = it
        })

        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter


        return binding.root
    }
}