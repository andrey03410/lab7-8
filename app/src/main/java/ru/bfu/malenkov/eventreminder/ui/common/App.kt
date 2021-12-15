package ru.bfu.malenkov.eventreminder.ui.common

import android.app.Application
import ru.bfu.malenkov.eventreminder.data.db.AppDatabase
import ru.bfu.malenkov.eventreminder.data.repository.EventReminderRepositoryDb
import ru.bfu.malenkov.eventreminder.domain.repository.EventReminderRepository
import ru.bfu.malenkov.eventreminder.ui.main.MainRouter

class App : Application() {

    private val appDatabase: AppDatabase by lazy { AppDatabase.getInstance(this) }
    lateinit var mainRouter: MainRouter

    val eventReminderRepository: EventReminderRepository by lazy {
        EventReminderRepositoryDb(appDatabase)
    }

    override fun onCreate() {
        super.onCreate()
    }
}