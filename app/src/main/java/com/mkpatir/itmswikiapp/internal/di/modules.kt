package com.mkpatir.itmswikiapp.internal.di

import com.mkpatir.itmswikiapp.data.remote.AppServiceFactory
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
}

val appKoinModules = listOf(appModule, viewModelModule)