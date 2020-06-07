package com.mkpatir.itmswikiapp.internal.helpers

import android.content.Context

class SharedPrefHelper(context: Context) {

    companion object {
        private const val APP_NAME = "com.mkpatir.itmswikiapp"
        private const val TOKEN = "token"
    }

    private val sharedPref = context.getSharedPreferences(APP_NAME,Context.MODE_PRIVATE)

    var authToken: String?
        get() = sharedPref.getString(TOKEN,null)
        set(value) = sharedPref.edit().putString(TOKEN,value).apply()

}