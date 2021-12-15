package ru.bfu.malenkov.eventreminder.ui.eventlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder
import ru.bfu.malenkov.eventreminder.ui.common.App
import ru.bfu.malenkov.eventreminder.ui.eventlist.adapter.EventReminderVM

class EventsViewModel(application: Application) : AndroidViewModel(application) {

    private val eventsReminderVM: MutableLiveData<List<EventReminderVM>> = MutableLiveData()

    init {
        loadEventsReminder()
    }

    fun getEvents(): LiveData<List<EventReminderVM>> {
        return eventsReminderVM
    }

    private fun loadEventsReminder() {
        viewModelScope.launch {
            getApplication<App>().eventReminderRepository
                .getEventReminderList()
                .collect {
                    eventsReminderVM.value = it.map { it.mapToEventReminderVM() }
                }
        }
    }

    fun showAddNewEventScreen() {
        getApplication<App>().mainRouter.showEventEditScreen()
    }

    private fun clickEventReminder(eventReminder: EventReminder) {
        eventReminder.id?.let {
            getApplication<App>().mainRouter.showEventDescriptionScreen(it)
        }
    }

    private fun EventReminder.mapToEventReminderVM() = EventReminderVM(this) {
        clickEventReminder(this)
    }
}