package com.mkpatir.itmswikiapp.domain.interactor.home.editmetric

import com.mkpatir.itmswikiapp.data.models.requeest.AddMetricRequest
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import com.mkpatir.itmswikiapp.domain.interactor.base.SingleUseCaseTwoParams
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import io.reactivex.rxjava3.core.Single

class EditMetricUseCase (
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val appRepository: AppRepository
): SingleUseCaseTwoParams<MetricDetailResponse, String, AddMetricRequest>(threadExecutor,postExecutionThread) {

    override fun buildSingleUseCase(param1: String, param2: AddMetricRequest): Single<MetricDetailResponse> = appRepository.updateMetric(param1,param2)

}