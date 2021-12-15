package ru.bfu.malenkov.eventreminder.ui.eventlist.adapter

import ru.bfu.malenkov.eventreminder.domain.model.EventReminder

data class EventReminderVM(
    val data: EventReminder,
    val onClick: () -> Unit
)