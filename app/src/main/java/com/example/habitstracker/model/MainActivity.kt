package com.example.habitstracker.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habitstracker.R
import com.example.habitstracker.databinding.ActivityMainBinding
import com.example.habitstracker.model.models.Habit
import com.example.habitstracker.model.models.HabitsService
import com.example.habitstracker.model.screens.HabitListFragment
import com.example.habitstracker.model.screens.HabitSettingsFragment

class MainActivity : AppCompatActivity(), HabitActionListener {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, HabitListFragment())
                .commit()
        }
    }

    override fun onClickHabitSettings(habit: Habit) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, HabitSettingsFragment.createSettingFragment(habit))
            .commit()
    }
}