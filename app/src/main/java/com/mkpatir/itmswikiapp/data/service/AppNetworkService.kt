package com.mkpatir.itmswikiapp.data.service

import com.mkpatir.itmswikiapp.data.models.requeest.LoginRequest
import com.mkpatir.itmswikiapp.data.models.requeest.RegisterRequest
import com.mkpatir.itmswikiapp.data.models.response.LoginResponse
import com.mkpatir.itmswikiapp.data.models.response.RegisterResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AppNetworkService {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    @POST("register")
    fun register(@Body registerRequest: RegisterRequest): Single<RegisterResponse>

}