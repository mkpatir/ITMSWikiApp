package com.mkpatir.itmswikiapp.presentation.ui.home.addorupdatemetric

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.mkpatir.itmswikiapp.data.models.requeest.AddMetricRequest
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.domain.interactor.home.addmetric.AddMetricObserver
import com.mkpatir.itmswikiapp.domain.interactor.home.addmetric.AddMetricUseCase
import com.mkpatir.itmswikiapp.domain.interactor.home.editmetric.EditMetricObserver
import com.mkpatir.itmswikiapp.domain.interactor.home.editmetric.EditMetricUseCase
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseViewModel

class AddOrUpdateMetricViewModel(
    private val addMetricUseCase: AddMetricUseCase,
    private val updateMetricUseCase: EditMetricUseCase
): BaseViewModel() {

    val lottieAnimationVisibility = ObservableField(false)
    val addButtonVisibility = ObservableField(true)
    val title = ObservableField("")
    val buttonText = ObservableField("")

    val addMetricLiveData = MutableLiveData<MetricDetailResponse>()
    val updateMetricLiveData = MutableLiveData<MetricDetailResponse>()

    fun addMetric(addMetricRequest: AddMetricRequest){
        setButtonVisibility(false)
        addMetricUseCase.execute(AddMetricObserver({
            addMetricLiveData.value = it
        },{
            setButtonVisibility(true)
            toastError()
        }),addMetricRequest)
    }

    fun updateMetric(id: String,addMetricRequest: AddMetricRequest){
        setButtonVisibility(false)
        updateMetricUseCase.execute(EditMetricObserver({
            updateMetricLiveData.value = it
        },{
            setButtonVisibility(true)
            toastError()
        }),id,addMetricRequest)
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