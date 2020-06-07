package com.mkpatir.itmswikiapp.internal.di

import com.mkpatir.itmswikiapp.data.repository.AppRepositoryImpl
import com.mkpatir.itmswikiapp.data.service.AppServiceFactory
import com.mkpatir.itmswikiapp.data.service.AuthTokenInterceptor
import com.mkpatir.itmswikiapp.domain.executor.JobExecutor
import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import com.mkpatir.itmswikiapp.domain.interactor.login.LoginUseCase
import com.mkpatir.itmswikiapp.domain.interactor.register.RegisterUseCase
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import com.mkpatir.itmswikiapp.internal.helpers.SharedPrefHelper
import com.mkpatir.itmswikiapp.presentation.UIThread
import com.mkpatir.itmswikiapp.presentation.ui.home.detail.DetailViewModel
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeViewModel
import com.mkpatir.itmswikiapp.presentation.ui.home.addmetric.AddMetricViewModel
import com.mkpatir.itmswikiapp.presentation.ui.login.LoginViewModel
import com.mkpatir.itmswikiapp.presentation.ui.register.RegisterViewModel
import com.mkpatir.itmswikiapp.presentation.ui.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module(true) {

    single { JobExecutor() as ThreadExecutor }
    single { UIThread() as PostExecutionThread }
    single { SharedPrefHelper(androidContext()) }
    single { AuthTokenInterceptor(get()) }

    factory<AppRepository> {
        AppRepositoryImpl(
            get()
        )
    }

    factory {
        AppServiceFactory.buildService(
            get()
        )
    }
}

val viewModelModule = module(true){
    viewModel { SplashViewModel() }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { RegisterViewModel(get(), get()) }
    viewModel { HomeViewModel() }
    viewModel { DetailViewModel() }
    viewModel { AddMetricViewModel() }
}

val useCaseModule = module(true) {
    factory { LoginUseCase(get(),get(),get()) }
    factory { RegisterUseCase(get(), get(), get()) }
}

val appKoinModules = listOf(appModule, viewModelModule, useCaseModule)