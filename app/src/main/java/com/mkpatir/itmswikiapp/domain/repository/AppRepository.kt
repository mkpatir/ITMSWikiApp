package com.mkpatir.itmswikiapp.domain.repository

import com.mkpatir.itmswikiapp.data.models.requeest.LoginRequest
import com.mkpatir.itmswikiapp.data.models.requeest.RegisterRequest
import com.mkpatir.itmswikiapp.data.models.response.LoginResponse
import com.mkpatir.itmswikiapp.data.models.response.RegisterResponse
import io.reactivex.rxjava3.core.Single

interface AppRepository {

    fun login(loginRequest: LoginRequest): Single<LoginResponse>

    fun register(registerRequest: RegisterRequest): Single<RegisterResponse>

}