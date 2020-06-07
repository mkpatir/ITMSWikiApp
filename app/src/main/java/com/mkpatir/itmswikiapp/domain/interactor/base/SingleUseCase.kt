package com.mkpatir.itmswikiapp.domain.interactor.base

import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.DisposableSingleObserver

abstract class SingleUseCase<Result, in Params>(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseUseCase(threadExecutor, postExecutionThread) {

    abstract fun buildSingleUseCase(params: Params): Single<Result>

    fun execute(observer: DisposableSingleObserver<Result> = BaseDisposableSingleObserver(), params: Params) {
        val single = buildSingleUseCaseWithSchedulers(params)
        addDisposable(single.subscribeWith(observer))
    }

    private fun buildSingleUseCaseWithSchedulers(params: Params): Single<Result> {
        return buildSingleUseCase(params)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
    }
}