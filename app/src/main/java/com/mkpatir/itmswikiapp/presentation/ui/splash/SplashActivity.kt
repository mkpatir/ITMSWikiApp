package com.mkpatir.itmswikiapp.presentation.ui.splash

import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.databinding.ActivitySplashBinding
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity: BaseActivity<SplashViewModel,ActivitySplashBinding>() {

    override fun setLayout(): Int = R.layout.activity_splash

    override fun setViewModel(): Lazy<SplashViewModel> = viewModel()

}