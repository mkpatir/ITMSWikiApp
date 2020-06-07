package com.mkpatir.itmswikiapp.domain.interactor.base

import io.reactivex.rxjava3.observers.DisposableSingleObserver

open class BaseDisposableSingleObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(result: T) {}

    override fun onError(throwable: Throwable) {}
}