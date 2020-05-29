package com.mkpatir.itmswikiapp.internal.di

import com.mkpatir.itmswikiapp.data.remote.AppServiceFactory
import com.mkpatir.itmswikiapp.presentation.ui.home.detail.DetailViewModel
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeViewModel
import com.mkpatir.itmswikiapp.presentation.ui.home.addmetric.AddMetricViewModel
import com.mkpatir.itmswikiapp.presentation.ui.login.LoginViewModel
import com.mkpatir.itmswikiapp.presentation.ui.register.RegisterViewModel
import com.mkpatir.itmswikiapp.presentation.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module(true) {
    factory {
        AppServiceFactory.buildService()
    }
}

val viewModelModule = module(true){
    viewModel { SplashViewModel() }
    viewModel { LoginViewModel() }
    viewModel { RegisterViewModel() }
    viewModel { HomeViewModel() }
    viewModel { DetailViewModel() }
    viewModel { AddMetricViewModel() }
}

val appKoinModules = listOf(appModule, viewModelModule)