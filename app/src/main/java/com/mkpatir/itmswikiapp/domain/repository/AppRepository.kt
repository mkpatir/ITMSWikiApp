package com.mkpatir.itmswikiapp.domain.repository

import com.mkpatir.itmswikiapp.data.models.requeest.LoginRequest
import com.mkpatir.itmswikiapp.data.models.requeest.RegisterRequest
import com.mkpatir.itmswikiapp.data.models.response.LoginResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import com.mkpatir.itmswikiapp.data.models.response.RegisterResponse
import io.reactivex.rxjava3.core.Single

interface AppRepository {

    fun login(loginRequest: LoginRequest): Single<LoginResponse>

    fun register(registerRequest: RegisterRequest): Single<RegisterResponse>

    fun getAllMetrics(): Single<ArrayList<MetricResponse>>

    fun getMetricDetails(id: String): Single<MetricDetailResponse>

}