package com.mkpatir.itmswikiapp.domain.interactor.home

import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import com.mkpatir.itmswikiapp.domain.interactor.base.SingleUseCaseNotParam
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import io.reactivex.rxjava3.core.Single

class GetAllMetricsUseCase(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val appRepository: AppRepository
): SingleUseCaseNotParam<ArrayList<MetricResponse>>(threadExecutor, postExecutionThread) {

    override fun buildSingleUseCase(): Single<ArrayList<MetricResponse>> = appRepository.getAllMetrics()
}