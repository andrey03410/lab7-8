package ru.bfu.malenkov.eventreminder.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.bfu.malenkov.eventreminder.R
import ru.bfu.malenkov.eventreminder.databinding.FragmentProfileBinding
import ru.bfu.malenkov.eventreminder.ui.common.LogLifecycle

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogLifecycle(lifecycle, "ProfileFragment")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileSettingsText.setOnClickListener {
            startActivity(Intent(requireContext(), SettingsActivity::class.java))
        }

        binding.profileAboutText.setOnClickListener {
            startActivity(
                AboutActivity.newInstance(requireContext(), "https://www.journaldev.com")
            )
        }

        binding.profileShareText.setOnClickListener {
            shareApp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun shareApp() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.shareDescription))
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

}