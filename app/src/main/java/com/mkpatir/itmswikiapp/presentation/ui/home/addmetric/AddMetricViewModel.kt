package com.mkpatir.itmswikiapp.presentation.ui.home.addmetric

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.mkpatir.itmswikiapp.data.models.requeest.AddMetricRequest
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.domain.interactor.home.addmetric.AddMetricObserver
import com.mkpatir.itmswikiapp.domain.interactor.home.addmetric.AddMetricUseCase
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseViewModel

class AddMetricViewModel(
    private val addMetricUseCase: AddMetricUseCase
): BaseViewModel() {

    val lottieAnimationVisibility = ObservableField(false)
    val addButtonVisibility = ObservableField(true)

    val addMetricLiveData = MutableLiveData<MetricDetailResponse>()

    fun addMetric(addMetricRequest: AddMetricRequest){
        setButtonVisibility(false)
        addMetricUseCase.execute(AddMetricObserver({
            addMetricLiveData.value = it
        },{
            setButtonVisibility(true)
            toastError()
        }),addMetricRequest)
    }

    private fun setButtonVisibility(isVisible: Boolean){
        if (isVisible){
            lottieAnimationVisibility.set(false)
            addButtonVisibility.set(true)
        }
        else{
            lottieAnimationVisibility.set(true)
            addButtonVisibility.set(false)
        }
    }
}