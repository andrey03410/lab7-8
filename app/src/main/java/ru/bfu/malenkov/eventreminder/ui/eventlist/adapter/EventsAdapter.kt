package ru.bfu.malenkov.eventreminder.ui.eventlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.bfu.malenkov.eventreminder.databinding.ItemEventReminderVhBinding

internal class EventsAdapter : RecyclerView.Adapter<EventVH>() {

    private val eventReminderList = mutableListOf<EventReminderVM>()

    fun reload(newData: List<EventReminderVM>) {
        eventReminderList.clear()
        eventReminderList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventVH {
        return EventVH(
            ItemEventReminderVhBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EventVH, position: Int) {
        holder.bind(eventReminderList[position])
    }

    override fun getItemCount(): Int = eventReminderList.size
}