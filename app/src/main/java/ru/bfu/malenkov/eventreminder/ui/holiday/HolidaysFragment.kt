package ru.bfu.malenkov.eventreminder.ui.holiday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.bfu.malenkov.eventreminder.databinding.FragmentHolidaysBinding

class HolidaysFragment : Fragment() {

    private var _binding: FragmentHolidaysBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHolidaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}