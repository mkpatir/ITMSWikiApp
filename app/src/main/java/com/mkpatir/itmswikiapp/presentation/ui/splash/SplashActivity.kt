package com.mkpatir.itmswikiapp.presentation.ui.splash

import android.app.ActivityOptions
import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Pair
import android.view.View
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.databinding.ActivitySplashBinding
import com.mkpatir.itmswikiapp.internal.helpers.SharedPrefHelper
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseActivity
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeActivity
import com.mkpatir.itmswikiapp.presentation.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity: BaseActivity<SplashViewModel,ActivitySplashBinding>() {

    companion object {

    }

    private lateinit var handler: Handler
    private lateinit var sharedPrefHelper: SharedPrefHelper

    private val runnable = Runnable {
        if (sharedPrefHelper.authToken.isNullOrBlank()){
            startLoginActivity()
        }
        else {
            startHomeActivity()
        }
    }

    override fun setLayout(): Int = R.layout.activity_splash

    override fun setViewModel(): Lazy<SplashViewModel> = viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefHelper = SharedPrefHelper(this)
        handler = Handler()
        startAnimation()
    }

    private fun startAnimation(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val drawable = splashIcon.drawable
            if (drawable is AnimatedVectorDrawable){
                drawable.start()
                drawable.registerAnimationCallback(object : Animatable2.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable?) {
                        if (sharedPrefHelper.authToken.isNullOrBlank()){
                            startLoginActivity()
                        }
                        else {
                            startHomeActivity()
                        }
                    }
                })
            }
        }
        else{
            splashIcon.setImageResource(R.drawable.ic_launcher)
            handler.postDelayed(runnable,1500)
        }
    }

    private fun startLoginActivity(){
        val pair = Pair<View,String>(splashIcon,getString(R.string.image_transition))
        val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,pair)
        startActivity(LoginActivity.callingIntent(this),activityOptions.toBundle())
        activityFinishAfterTransition()
    }

    private fun startHomeActivity(){
        val pair = Pair<View,String>(splashIcon,getString(R.string.image_transition))
        val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,pair)
        startActivity(HomeActivity.callingIntent(this),activityOptions.toBundle())
        activityFinishAfterTransition()
    }
}