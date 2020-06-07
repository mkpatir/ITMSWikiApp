package com.mkpatir.itmswikiapp.domain.interactor.home.detail

import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.domain.interactor.base.BaseDisposableSingleObserver

class GetMetricDetailsObserver(
    private val successCallback: (MetricDetailResponse) -> Unit,
    private val errorCallback: () -> Unit
): BaseDisposableSingleObserver<MetricDetailResponse>() {

    override fun onSuccess(result: MetricDetailResponse) {
        successCallback(result)
    }

    override fun onError(throwable: Throwable) {
        super.onError(throwable)
        errorCallback()
    }

}