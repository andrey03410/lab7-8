package ru.bfu.malenkov.eventreminder.ui.eventdesc

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder
import ru.bfu.malenkov.eventreminder.ui.common.App

class EventDescriptionVM(application: Application) : AndroidViewModel(application) {

    private val eventReminderData: MutableLiveData<EventReminder> = MutableLiveData()

    fun getEventReminder(): LiveData<EventReminder> = eventReminderData
    private lateinit var eventReminder: EventReminder
    private val titleObs = object : ObservableField<String>() {
        override fun set(value: String?) {
            super.set(value)
            eventReminder = eventReminder?.copy(title = value!!)
        }
    }

    fun loadData(eventId: Int) {
        viewModelScope.launch {
            val event = getApplication<App>().eventReminderRepository.getEventReminder(eventId)
            eventReminderData.value = event
            eventReminder = event ?: EventReminder.emptyEventReminder()
            eventReminder?.run {
                titleObs.set(title)
            }
        }
    }

    fun removeEvent() {
        viewModelScope.launch {
            eventReminderData.value?.let {
                getApplication<App>().eventReminderRepository.removeEventReminder(it)
            }
            closeView()
        }
    }

    fun editEvent() {
        getApplication<App>().mainRouter.showEventEditScreen(eventReminderData.value?.id ?: -1)
    }

    private fun closeView() {
        getApplication<App>().mainRouter.back()
    }
}