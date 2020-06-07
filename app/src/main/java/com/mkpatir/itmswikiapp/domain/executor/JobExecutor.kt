package com.mkpatir.itmswikiapp.domain.executor

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class JobExecutor: ThreadExecutor {

    companion object {
        private const val THREAD_POOL = 3
    }

    private val threadPoolExecutor: Executor = Executors.newFixedThreadPool(THREAD_POOL)

    override fun execute(runnable: Runnable) {
        threadPoolExecutor.execute(runnable)
    }
}