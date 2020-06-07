package com.mkpatir.itmswikiapp.domain.interactor.base

import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.DisposableSingleObserver

abstract class SingleUseCaseTwoParams<Result, in Param1, in Param2>(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : BaseUseCase(threadExecutor, postExecutionThread) {

    abstract fun buildSingleUseCase(param1: Param1,param2: Param2): Single<Result>

    fun execute(observer: DisposableSingleObserver<Result> = BaseDisposableSingleObserver(), param1: Param1,param2: Param2) {
        val single = buildSingleUseCaseWithSchedulers(param1,param2)
        addDisposable(single.subscribeWith(observer))
    }

    private fun buildSingleUseCaseWithSchedulers(param1: Param1, param2: Param2): Single<Result> {
        return buildSingleUseCase(param1, param2)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
    }
}