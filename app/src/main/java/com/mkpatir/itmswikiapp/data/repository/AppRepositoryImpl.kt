package com.mkpatir.itmswikiapp.data.repository

import com.mkpatir.itmswikiapp.data.models.requeest.AddMetricRequest
import com.mkpatir.itmswikiapp.data.models.requeest.LoginRequest
import com.mkpatir.itmswikiapp.data.models.requeest.RegisterRequest
import com.mkpatir.itmswikiapp.data.models.response.LoginResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import com.mkpatir.itmswikiapp.data.models.response.RegisterResponse
import com.mkpatir.itmswikiapp.data.service.AppNetworkService
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import io.reactivex.rxjava3.core.Single

class AppRepositoryImpl constructor(private val appNetworkService: AppNetworkService):
    AppRepository {

    override fun login(loginRequest: LoginRequest): Single<LoginResponse> = appNetworkService.login(loginRequest)

    override fun register(registerRequest: RegisterRequest): Single<RegisterResponse> = appNetworkService.register(registerRequest)

    override fun getAllMetrics(): Single<ArrayList<MetricResponse>> = appNetworkService.getAllMetrics()

    override fun getMetricDetails(id: String): Single<MetricDetailResponse> = appNetworkService.getMetricDetails(id)

    override fun addMetric(addMetricRequest: AddMetricRequest): Single<MetricDetailResponse> = appNetworkService.addMetric(addMetricRequest)

}