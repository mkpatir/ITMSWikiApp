package com.mkpatir.itmswikiapp.presentation.ui.register

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.mkpatir.itmswikiapp.data.models.requeest.RegisterRequest
import com.mkpatir.itmswikiapp.data.models.response.RegisterResponse
import com.mkpatir.itmswikiapp.domain.interactor.register.RegisterObserver
import com.mkpatir.itmswikiapp.domain.interactor.register.RegisterUseCase
import com.mkpatir.itmswikiapp.internal.helpers.SharedPrefHelper
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseViewModel

class RegisterViewModel(
    private val registerUseCase: RegisterUseCase,
    private val sharedPrefHelper: SharedPrefHelper
): BaseViewModel() {

    /**
     * UI Properties
     */

    var registerButtonVisibility = ObservableField<Boolean>(true)
    var lottieAnimationVisibility = ObservableField<Boolean>(false)

    /**
     * Live Data
     */

    val registerLiveData = MutableLiveData<RegisterResponse>()

    fun register(email: String, name: String, surname: String, password: String){
        setRegisterButtonVisibility(false)
        registerUseCase.execute(RegisterObserver({
            sharedPrefHelper.authToken = it.token
            registerLiveData.value = it
        },{
            toastError()
            setRegisterButtonVisibility(true)
        }), RegisterRequest(email, password, name, surname))
    }

    private fun setRegisterButtonVisibility(isVisible: Boolean){
        if (isVisible){
            registerButtonVisibility.set(true)
            lottieAnimationVisibility.set(false)
        }
        else{
            registerButtonVisibility.set(false)
            lottieAnimationVisibility.set(true)
        }
    }
}