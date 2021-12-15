package ru.bfu.malenkov.eventreminder.ui.common

import android.content.Context
import androidx.fragment.app.Fragment
import ru.bfu.malenkov.eventreminder.ui.main.MainRouter

abstract class BaseFragment : Fragment() {

    lateinit var mainRouter: MainRouter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainRouter = (context.applicationContext as App).mainRouter
    }
}