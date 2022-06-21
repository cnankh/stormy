package com.example.stormy.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel constructor(open val dispatcher: CoroutineDispatcher) :
    ViewModel(), CoroutineScope {
    private val job = Job()


    override val coroutineContext: CoroutineContext
        get() = job + dispatcher

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}