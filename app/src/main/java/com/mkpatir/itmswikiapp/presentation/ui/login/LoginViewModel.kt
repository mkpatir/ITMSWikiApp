package com.mkpatir.itmswikiapp.presentation.ui.login

import android.util.Log
import androidx.databinding.ObservableField
import com.mkpatir.itmswikiapp.data.models.requeest.LoginRequest
import com.mkpatir.itmswikiapp.domain.interactor.login.LoginObserver
import com.mkpatir.itmswikiapp.domain.interactor.login.LoginUseCase
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseViewModel

class LoginViewModel(
    private val loginUseCase: LoginUseCase
): BaseViewModel() {

    //Button Properties
    var isButtonEnabled = ObservableField(false)

    // Texts
    var email = ObservableField("")
    var password = ObservableField("")

    fun setButtonEnable(isEnable: Boolean){
        isButtonEnabled.set(isEnable)
        isButtonEnabled.notifyChange()
    }

    fun login(email: String,password: String){
        loginUseCase.execute(
            LoginObserver({

            },{

            }), LoginRequest(email, password)
        )
    }
}