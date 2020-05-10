package com.mkpatir.itmswikiapp.presentation.ui.register

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.databinding.ActivityRegisterBinding
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseActivity
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity: BaseActivity<RegisterViewModel,ActivityRegisterBinding>(), RegisterHandler {

    override fun setLayout(): Int = R.layout.activity_register

    override fun setViewModel(): Lazy<RegisterViewModel> = viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataBinding().registerHandler = this
    }

    companion object{
        fun callingIntent(context: Context): Intent = Intent(context, RegisterActivity::class.java).apply {

        }
    }

    override fun backButtonClick(view: View) {
        onBackPressed()
    }

    override fun registerClick(view: View) {
        val imageTransition = Pair<View,String>(appIcon,getString(R.string.image_transition))
        val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,imageTransition)
        startActivity(HomeActivity.callingIntent(this), activityOptions.toBundle())
        activityFinishAfterTransition()
    }
}