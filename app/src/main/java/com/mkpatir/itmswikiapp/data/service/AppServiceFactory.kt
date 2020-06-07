package com.mkpatir.itmswikiapp.data.service

import com.mkpatir.itmswikiapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppServiceFactory {

    fun buildService(): AppNetworkService{
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_ADRESS)
            .client(buildHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(AppNetworkService::class.java)
        return service
    }

    private fun buildHttpClient(): OkHttpClient{
        val okHttpClientBuilder = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return okHttpClientBuilder.build()
    }

}