package com.mkpatir.itmswikiapp.presentation.ui.register

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import androidx.lifecycle.Observer
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.databinding.ActivityRegisterBinding
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseActivity
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity: BaseActivity<RegisterViewModel,ActivityRegisterBinding>(), RegisterHandler {

    companion object{
        fun callingIntent(context: Context): Intent = Intent(context, RegisterActivity::class.java).apply {

        }
    }

    override fun setLayout(): Int = R.layout.activity_register

    override fun setViewModel(): Lazy<RegisterViewModel> = viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataBinding().apply {
            registerHandler = this@RegisterActivity
            viewModel = this@RegisterActivity.getViewModel()
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        getViewModel().apply {
            registerLiveData.observe(this@RegisterActivity, Observer {
                val imageTransition = Pair<View,String>(appIcon,getString(R.string.image_transition))
                val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this@RegisterActivity,imageTransition)
                startActivity(HomeActivity.callingIntent(this@RegisterActivity), activityOptions.toBundle())
                activityFinishAfterTransition()
            })
        }
    }

    override fun backButtonClick(view: View) {
        onBackPressed()
    }

    override fun registerClick(view: View) {
        getDataBinding().apply {
            if (registerEmail.text.toString().isBlank() || registerName.text.toString().isBlank() || registerSurname.text.toString().isBlank() || registerPassword.text.toString().isBlank()){
                showToast(getString(R.string.empty_field_error))
            }
            else{
                this@RegisterActivity.getViewModel().register(
                    registerEmail.text.toString(),
                    registerName.text.toString(),
                    registerSurname.text.toString(),
                    registerPassword.text.toString()
                )
            }
        }
    }
}