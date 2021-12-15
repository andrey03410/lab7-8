package ru.bfu.malenkov.eventreminder.data.db.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.bfu.malenkov.eventreminder.data.db.helpers.TABLE_EVENT_REMINDER
import ru.bfu.malenkov.eventreminder.data.db.model.EventReminderDb

@Dao
interface EventReminderDao {

    @Query("SELECT * FROM $TABLE_EVENT_REMINDER")
    fun getAll(): Flow<List<EventReminderDb>>

    @Query("SELECT * FROM $TABLE_EVENT_REMINDER WHERE id == :id")
    fun getById(id: Int): List<EventReminderDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(events: List<EventReminderDb>)

    @Delete
    fun remove(eventReminderDb: EventReminderDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(eventReminderDb: EventReminderDb)
}