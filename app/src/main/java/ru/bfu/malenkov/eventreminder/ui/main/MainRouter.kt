package ru.bfu.malenkov.eventreminder.ui.main

import androidx.fragment.app.FragmentManager
import ru.bfu.malenkov.eventreminder.R
import ru.bfu.malenkov.eventreminder.ui.eventdesc.EventDescriptionFragment
import ru.bfu.malenkov.eventreminder.ui.eventedit.EventEditFragment

class MainRouter(
    private val fragmentManager: FragmentManager
) {

    fun showEventDescriptionScreen(eventId: Int) {
        val tag = EventDescriptionFragment::class.java.name
        fragmentManager.beginTransaction()
            .replace(R.id.full_content, EventDescriptionFragment.newInstance(eventId))
            .addToBackStack(tag)
            .commit()
    }

    fun showEventEditScreen(eventId: Int = -1) {
        val tag = EventEditFragment::class.java.name
        fragmentManager.beginTransaction()
            .replace(R.id.full_content, EventEditFragment.newInstance(eventId))
            .addToBackStack(tag)
            .commit()
    }

    fun back() = fragmentManager.popBackStack()
}