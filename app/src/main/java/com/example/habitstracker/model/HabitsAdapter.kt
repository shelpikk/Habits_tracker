package com.example.habitstracker.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.habitstracker.databinding.ItemHabitBinding
import com.example.habitstracker.model.models.Habit

interface HabitActionListener {

    fun onClickHabitSettings(habit: Habit)

}


class HabitsAdapter(
    private val actionListener: HabitActionListener
) : RecyclerView.Adapter<HabitsAdapter.HabitsViewHolder>(), View.OnClickListener {

    var habits: List<Habit> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onClick(v: View) {
        val habit = v.tag as Habit
        actionListener.onClickHabitSettings(habit)
    }

    override fun getItemCount(): Int = habits.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHabitBinding.inflate(inflater, parent, false)

        binding.habitsSettings.setOnClickListener(this)

        return HabitsViewHolder(binding, actionListener)
    }

    override fun onBindViewHolder(holder: HabitsViewHolder, position: Int) {
        holder.bind(habits[position])
    }

    class HabitsViewHolder(
        private val binding: ItemHabitBinding,
        private val actionListener: HabitActionListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: Habit) {
            with(binding) {

                habitsSettings.setOnClickListener {
                    actionListener.onClickHabitSettings(habit)
                }

                habitsId.text = "${habit.id})"

                habitsDescription.text = habit.description

            }
        }
    }
}