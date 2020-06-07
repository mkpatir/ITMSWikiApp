package com.mkpatir.itmswikiapp.domain.interactor.home

import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import com.mkpatir.itmswikiapp.domain.interactor.base.BaseDisposableSingleObserver

class GetAllMetricsObserver(
    private val successCallback: (ArrayList<MetricResponse>) -> Unit,
    private val errorCallback: () -> Unit
): BaseDisposableSingleObserver<ArrayList<MetricResponse>>() {

    override fun onSuccess(result: ArrayList<MetricResponse>) {
        successCallback(result)
    }

    override fun onError(throwable: Throwable) {
        super.onError(throwable)
        errorCallback()
    }

}