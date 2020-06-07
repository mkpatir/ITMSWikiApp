package com.mkpatir.itmswikiapp.presentation.ui.home.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.domain.interactor.home.detail.GetMetricDetailsObserver
import com.mkpatir.itmswikiapp.domain.interactor.home.detail.GetMetricDetailsUseCase
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseViewModel

class DetailViewModel(
    private val getMetricDetailsUseCase: GetMetricDetailsUseCase
): BaseViewModel() {

    val name = ObservableField("")
    val goal = ObservableField("")
    val type = ObservableField("")
    val period = ObservableField("")

    val metricDetailsLiveData = MutableLiveData<MetricDetailResponse>()

    fun getMetricDetails(id: String){
        getMetricDetailsUseCase.execute(GetMetricDetailsObserver({
            metricDetailsLiveData.value = it
            name.set(it.name)
            goal.set(it.goal)
            type.set(it.measurementType)
            period.set(it.measurementPeriod)
        },{
            toastError()
        }),id)
    }

}