package com.mkpatir.itmswikiapp.domain.interactor.register

import com.mkpatir.itmswikiapp.data.models.response.RegisterResponse
import com.mkpatir.itmswikiapp.domain.interactor.base.BaseDisposableSingleObserver

class RegisterObserver(
    private val successCallback: (RegisterResponse) -> Unit,
    private val errorCallback: () -> Unit
): BaseDisposableSingleObserver<RegisterResponse>() {

    override fun onSuccess(result: RegisterResponse) {
        successCallback(result)
    }

    override fun onError(throwable: Throwable) {
        super.onError(throwable)
        errorCallback()
    }

}