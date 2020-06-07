package com.mkpatir.itmswikiapp.domain.interactor.login

import com.mkpatir.itmswikiapp.data.models.response.LoginResponse
import com.mkpatir.itmswikiapp.domain.interactor.base.BaseDisposableSingleObserver

class LoginObserver(
    private val successCallback: (LoginResponse) -> Unit,
    private val errorCallback: () -> Unit
): BaseDisposableSingleObserver<LoginResponse>() {

    override fun onSuccess(result: LoginResponse) {
        successCallback(result)
    }

    override fun onError(throwable: Throwable) {
        super.onError(throwable)
        errorCallback()
    }
}