package com.mkpatir.itmswikiapp.internal.extention

import android.widget.EditText

fun isAnyTextEmpty(vararg editText: EditText): Boolean{
    var response = false
    editText.forEach {
        if (it.text.toString().isBlank()){
            response = true
        }
    }
    return response
}

fun getTextFromView(editText: EditText): String{
    return editText.text.toString()
}