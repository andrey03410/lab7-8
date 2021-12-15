package ru.bfu.malenkov.eventreminder.ui.eventedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.datepicker.MaterialDatePicker
import ru.bfu.malenkov.eventreminder.databinding.FragmentEventEditBinding
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder
import ru.bfu.malenkov.eventreminder.ui.common.BaseFragment
import ru.bfu.malenkov.eventreminder.ui.eventlist.adapter.EventVH
import java.util.*

class EventEditFragment : BaseFragment() {

    private var _binding: FragmentEventEditBinding? = null
    private val binding get() = _binding!!

    private val eventEditVM: EventEditVM by viewModels()

    companion object {
        private const val ARG_EVENT_ID = "ARG_EVENT_ID"
        fun newInstance(eventId: Int): Fragment {
            return EventEditFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_EVENT_ID, eventId)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentEventEditBinding.inflate(inflater, container, false)
            .apply {
                viewModel = eventEditVM
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt(ARG_EVENT_ID)
        id?.let(eventEditVM::loadData)

        initToolbar()
        initDatePicker()
    }

    private fun initToolbar() {
        binding.apply {
            eventEditToolbar.setNavigationOnClickListener { mainRouter.back() }
        }
    }

    private fun initDatePicker() {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
        fragmentManager?.let { datePicker.show(it,null) }
        datePicker.addOnPositiveButtonClickListener() {
            eventEditVM.dateStringObs.set(Date(it))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}