package com.mkpatir.itmswikiapp.domain.interactor.base

import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.DisposableSingleObserver

abstract class SingleUseCaseNotParam<Result>(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
): BaseUseCase(threadExecutor, postExecutionThread) {

    abstract fun buildSingleUseCase(): Single<Result>

    fun execute(observer: DisposableSingleObserver<Result> = BaseDisposableSingleObserver()) {
        val single = buildSingleUseCaseWithSchedulers()
        addDisposable(single.subscribeWith(observer))
    }

    private fun buildSingleUseCaseWithSchedulers(): Single<Result> {
        return buildSingleUseCase()
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
    }
}