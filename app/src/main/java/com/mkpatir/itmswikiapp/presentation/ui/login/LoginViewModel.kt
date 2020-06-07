package com.mkpatir.itmswikiapp.presentation.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.mkpatir.itmswikiapp.data.models.requeest.LoginRequest
import com.mkpatir.itmswikiapp.data.models.response.LoginResponse
import com.mkpatir.itmswikiapp.domain.interactor.login.LoginObserver
import com.mkpatir.itmswikiapp.domain.interactor.login.LoginUseCase
import com.mkpatir.itmswikiapp.internal.helpers.SharedPrefHelper
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseViewModel

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val sharedPrefHelper: SharedPrefHelper
): BaseViewModel() {

    /**
     * UI Properties
     */
    var buttonEnabled = ObservableField(false)

    var loginButtonVisibility = ObservableField<Boolean>(true)
    var lottieAnimationVisibility = ObservableField<Boolean>(false)

    // Texts
    var email = ObservableField("")
    var password = ObservableField("")

    /**
     *  Live Data
     */

    val loginLiveData = MutableLiveData<LoginResponse>()

    fun setButtonEnable(isEnable: Boolean){
        buttonEnabled.set(isEnable)
    }

    fun login(email: String,password: String){
        setLoginButtonVisibility(false)
        loginUseCase.execute(
            LoginObserver({
                sharedPrefHelper.authToken = it.token
                loginLiveData.value = it
            },{
                toastError()
                setLoginButtonVisibility(true)
            }), LoginRequest(email, password)
        )
    }

    private fun setLoginButtonVisibility(isVisible: Boolean){
        if (isVisible){
            loginButtonVisibility.set(true)
            lottieAnimationVisibility.set(false)
        }
        else{
            loginButtonVisibility.set(false)
            lottieAnimationVisibility.set(true)
        }
    }
}