package com.mkpatir.itmswikiapp.domain.interactor.home.addmetric

import com.mkpatir.itmswikiapp.data.models.requeest.AddMetricRequest
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import com.mkpatir.itmswikiapp.domain.interactor.base.SingleUseCase
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import io.reactivex.rxjava3.core.Single

class AddMetricUseCase(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val appRepository: AppRepository
): SingleUseCase<MetricDetailResponse, AddMetricRequest>(threadExecutor,postExecutionThread) {

    override fun buildSingleUseCase(params: AddMetricRequest): Single<MetricDetailResponse> = appRepository.addMetric(params)
}