package com.mkpatir.itmswikiapp.presentation.ui.login

import android.text.TextWatcher
import android.view.View

interface LoginHandler {

    fun loginClick(view: View)
    fun registerClick(view: View)
    fun emailTextChange(s: CharSequence,start: Int,before : Int, count :Int)
    fun passwordTextChange(s: CharSequence,start: Int,before : Int, count :Int)

}