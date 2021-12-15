package ru.bfu.malenkov.eventreminder.data.mapper

import ru.bfu.malenkov.eventreminder.data.db.model.EventReminderDb
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder

fun EventReminder.mapToDb() = with(this) {
    EventReminderDb(id, title, desc, dateStart)
}