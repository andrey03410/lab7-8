package ru.bfu.malenkov.eventreminder.ui.common

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

internal class LogLifecycle(
    private val lifecycle: Lifecycle,
    tag: String
) : LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    val logTag = "LogLifecycle:$tag"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        Log.d(logTag, "ui ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() {
        Log.d(logTag, "ui ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() {
        Log.d(logTag, "ui ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        Log.d(logTag, "ui ON_DESTROY")
        lifecycle.removeObserver(this)
    }
}