package com.mkpatir.itmswikiapp.internal.extention

import android.view.View

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.gone(){
    visibility = View.GONE
}

fun View.isVisible(): Boolean = visibility == View.VISIBLE