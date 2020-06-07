package com.mkpatir.itmswikiapp.domain.interactor.register

import com.mkpatir.itmswikiapp.data.models.requeest.RegisterRequest
import com.mkpatir.itmswikiapp.data.models.response.RegisterResponse
import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import com.mkpatir.itmswikiapp.domain.interactor.base.SingleUseCase
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import io.reactivex.rxjava3.core.Single

class RegisterUseCase(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val appRepository: AppRepository
): SingleUseCase<RegisterResponse,RegisterRequest>(threadExecutor,postExecutionThread) {

    override fun buildSingleUseCase(params: RegisterRequest): Single<RegisterResponse> = appRepository.register(params)

}