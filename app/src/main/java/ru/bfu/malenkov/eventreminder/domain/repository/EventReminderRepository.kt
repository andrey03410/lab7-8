package ru.bfu.malenkov.eventreminder.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder

interface EventReminderRepository {

    suspend fun getEventReminderList(): Flow<List<EventReminder>>

    suspend fun getEventReminder(id: Int): EventReminder?

    suspend fun removeEventReminder(eventReminder: EventReminder)

    suspend fun saveEventReminder(eventReminder: EventReminder)
}