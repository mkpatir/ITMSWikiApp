package com.mkpatir.itmswikiapp.data.service

import com.mkpatir.itmswikiapp.internal.helpers.SharedPrefHelper
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor(private val sharedPrefHelper: SharedPrefHelper): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sharedPrefHelper.authToken?.let {
            requestBuilder.addHeader("Authorization","Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }

}