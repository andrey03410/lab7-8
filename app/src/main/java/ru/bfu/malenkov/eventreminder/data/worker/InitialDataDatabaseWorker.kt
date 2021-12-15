package ru.bfu.malenkov.eventreminder.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.bfu.malenkov.eventreminder.data.db.AppDatabase
import ru.bfu.malenkov.eventreminder.data.db.model.EventReminderDb
import java.util.*

class InitialDataDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        val list = listOf(
            EventReminderDb(1, "День рождение Андрея", "Нужно поздравить с утра", Date()),
            EventReminderDb(2, "День рождение Виктора", "Длинное описание. Ооооочень длииннное описание события. Ну оооооочень длинное описание ", Date()),
            EventReminderDb(3, "День группы", "", Date()),
        )

        try {
            val database = AppDatabase.getInstance(applicationContext)
            database.eventReminderDao().insertAll(list)
            Result.success()
        } catch (ex: Exception) {
            Result.failure()
        }
    }
}