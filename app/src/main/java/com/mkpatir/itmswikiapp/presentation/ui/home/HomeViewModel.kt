package com.mkpatir.itmswikiapp.presentation.ui.home

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import com.mkpatir.itmswikiapp.domain.interactor.home.GetAllMetricsObserver
import com.mkpatir.itmswikiapp.domain.interactor.home.GetAllMetricsUseCase
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseViewModel

class HomeViewModel(
    private val getAllMetricsUseCase: GetAllMetricsUseCase
): BaseViewModel() {

    val metricsCount = ObservableField("0")

    val allMetricsLiveData = MutableLiveData<ArrayList<MetricResponse>>()

    fun getAllMetrics(){
        getAllMetricsUseCase.execute(GetAllMetricsObserver({
            allMetricsLiveData.value = it
        },{
            toastError()
        }))
    }
}