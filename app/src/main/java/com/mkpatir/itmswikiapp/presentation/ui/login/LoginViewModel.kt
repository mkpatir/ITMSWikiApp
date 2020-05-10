package com.mkpatir.itmswikiapp.presentation.ui.login

import androidx.databinding.ObservableField
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseViewModel

class LoginViewModel: BaseViewModel() {

    //Button Properties
    var isButtonEnabled = ObservableField(false)

    // Texts
    var email = ObservableField("")
    var password = ObservableField("")

    fun setButtonEnable(isEnable: Boolean){
        isButtonEnabled.set(isEnable)
        isButtonEnabled.notifyChange()
    }
}