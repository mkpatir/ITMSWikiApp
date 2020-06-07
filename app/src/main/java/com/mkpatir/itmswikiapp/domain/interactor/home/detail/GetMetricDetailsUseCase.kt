package com.mkpatir.itmswikiapp.domain.interactor.home.detail

import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import com.mkpatir.itmswikiapp.domain.interactor.base.SingleUseCase
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import io.reactivex.rxjava3.core.Single

class GetMetricDetailsUseCase(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val appRepository: AppRepository
): SingleUseCase<MetricDetailResponse, String>(threadExecutor,postExecutionThread) {

    override fun buildSingleUseCase(params: String): Single<MetricDetailResponse> = appRepository.getMetricDetails(params)

}