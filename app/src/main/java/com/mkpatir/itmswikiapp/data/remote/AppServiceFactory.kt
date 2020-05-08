package com.mkpatir.itmswikiapp.data.remote

import com.mkpatir.itmswikiapp.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppServiceFactory {

    fun buildService(): AppNetworkService{
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_ADRESS)
            .client(buildHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(AppNetworkService::class.java)
        return service
    }

    private fun buildHttpClient(): OkHttpClient{
        return OkHttpClient.Builder().build()
    }

}