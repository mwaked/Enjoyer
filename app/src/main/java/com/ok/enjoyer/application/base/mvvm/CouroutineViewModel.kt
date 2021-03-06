package com.ok.enjoyer.application.base.mvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

open class CouroutineViewModel(private val uiContext: CoroutineContext) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = uiContext + job

    private val job = SupervisorJob()

    public override fun onCleared() {
        super.onCleared()
        coroutineContext.cancelChildren()
    }
}