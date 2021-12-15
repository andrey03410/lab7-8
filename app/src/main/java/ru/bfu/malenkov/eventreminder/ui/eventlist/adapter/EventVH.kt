package ru.bfu.malenkov.eventreminder.ui.eventlist.adapter

import android.view.View
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import ru.bfu.malenkov.eventreminder.databinding.ItemEventReminderVhBinding
import java.text.SimpleDateFormat
import java.util.*

internal class EventVH(private val binding: ItemEventReminderVhBinding) : RecyclerView.ViewHolder(binding.root) {

    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy hh:mm", Locale.getDefault())

    fun bind(eventReminderVM: EventReminderVM) {
        val eventReminder = eventReminderVM.data
        binding.apply {
            setVariable(BR.viewModel, eventReminderVM)
            itemEventReminderDesc.visibility = if (eventReminder.desc.isBlank()) View.GONE else View.VISIBLE

            itemEventReminderDate.text = simpleDateFormat.format(eventReminder.dateStart)
        }
    }
}