package com.mkpatir.itmswikiapp.data.service

import com.mkpatir.itmswikiapp.data.models.requeest.AddMetricRequest
import com.mkpatir.itmswikiapp.data.models.requeest.LoginRequest
import com.mkpatir.itmswikiapp.data.models.requeest.RegisterRequest
import com.mkpatir.itmswikiapp.data.models.response.LoginResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import com.mkpatir.itmswikiapp.data.models.response.RegisterResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface AppNetworkService {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    @POST("register")
    fun register(@Body registerRequest: RegisterRequest): Single<RegisterResponse>

    @GET("metric")
    fun getAllMetrics(): Single<ArrayList<MetricResponse>>

    @GET("metric/{id}")
    fun getMetricDetails(@Path("id") id: String): Single<MetricDetailResponse>

    @POST("metric")
    fun addMetric(@Body addMetricRequest: AddMetricRequest): Single<MetricDetailResponse>

}