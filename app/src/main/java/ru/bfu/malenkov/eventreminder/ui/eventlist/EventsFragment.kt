package ru.bfu.malenkov.eventreminder.ui.eventlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bfu.malenkov.eventreminder.databinding.FragmentEventListBinding
import ru.bfu.malenkov.eventreminder.ui.eventlist.adapter.EventsAdapter

class EventsFragment : Fragment() {

    private var _binding: FragmentEventListBinding? = null
    private val binding get() = _binding!!

    private val eventsAdapter = EventsAdapter()

    private val eventsViewModel: EventsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentEventListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.eventsRecyclerView.apply {
            adapter = eventsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        binding.addEventReminder.setOnClickListener {
            eventsViewModel.showAddNewEventScreen()
        }

        eventsViewModel.getEvents().observe(viewLifecycleOwner) {
            eventsAdapter.reload(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}