package com.mkpatir.itmswikiapp.presentation.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mkpatir.itmswikiapp.domain.interactor.base.BaseUseCase

abstract class BaseViewModel(vararg useCases: BaseUseCase): ViewModel() {

    private var useCaseList: ArrayList<BaseUseCase> = arrayListOf()

    val errorLiveData = MutableLiveData<String>()

    init {
        useCaseList.addAll(useCases)
    }

    override fun onCleared() {
        super.onCleared()
        useCaseList.forEach {
            it.dispose()
        }
    }

    fun toastError(){
        errorLiveData.value = "Bir hata oluştu. !"
    }
}