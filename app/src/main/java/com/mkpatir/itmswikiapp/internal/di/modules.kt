package com.mkpatir.itmswikiapp.internal.di

import com.mkpatir.itmswikiapp.data.repository.AppRepositoryImpl
import com.mkpatir.itmswikiapp.data.service.AppServiceFactory
import com.mkpatir.itmswikiapp.data.service.AuthTokenInterceptor
import com.mkpatir.itmswikiapp.domain.executor.JobExecutor
import com.mkpatir.itmswikiapp.domain.executor.PostExecutionThread
import com.mkpatir.itmswikiapp.domain.executor.ThreadExecutor
import com.mkpatir.itmswikiapp.domain.interactor.home.GetAllMetricsUseCase
import com.mkpatir.itmswikiapp.domain.interactor.home.addmetric.AddMetricUseCase
import com.mkpatir.itmswikiapp.domain.interactor.home.detail.GetMetricDetailsUseCase
import com.mkpatir.itmswikiapp.domain.interactor.home.editmetric.EditMetricUseCase
import com.mkpatir.itmswikiapp.domain.interactor.login.LoginUseCase
import com.mkpatir.itmswikiapp.domain.interactor.register.RegisterUseCase
import com.mkpatir.itmswikiapp.domain.repository.AppRepository
import com.mkpatir.itmswikiapp.internal.helpers.SharedPrefHelper
import com.mkpatir.itmswikiapp.presentation.UIThread
import com.mkpatir.itmswikiapp.presentation.ui.home.detail.DetailViewModel
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeViewModel
import com.mkpatir.itmswikiapp.presentation.ui.home.addorupdatemetric.AddOrUpdateMetricViewModel
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
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { AddOrUpdateMetricViewModel(get(), get()) }
}

val useCaseModule = module(true) {
    factory { LoginUseCase(get(),get(),get()) }
    factory { RegisterUseCase(get(), get(), get()) }
    factory { GetAllMetricsUseCase(get(), get(), get()) }
    factory { GetMetricDetailsUseCase(get(), get(), get()) }
    factory { AddMetricUseCase(get(), get(), get()) }
    factory { EditMetricUseCase(get(), get(), get()) }
}

val appKoinModules = listOf(appModule, viewModelModule, useCaseModule)