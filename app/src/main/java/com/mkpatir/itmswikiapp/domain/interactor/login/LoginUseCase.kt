package com.mkpatir.itmswikiapp.domain.interactor.login

import com.mkpatir.itmswikiapp.data.models.requeest.LoginRequest
import com.mkpatir.itmswikiapp.data.models.response.LoginResponse
import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import com.mkpatir.itmswikiapp.domain.interactor.base.SingleUseCase
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import io.reactivex.rxjava3.core.Single

class LoginUseCase(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val appRepository: AppRepository
): SingleUseCase<LoginResponse,LoginRequest>(threadExecutor,postExecutionThread) {

    override fun buildSingleUseCase(params: LoginRequest): Single<LoginResponse> = appRepository.login(params)

}