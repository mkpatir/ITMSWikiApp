package com.mkpatir.itmswikiapp.presentation.ui.login

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.databinding.ActivityLoginBinding
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseActivity
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeActivity
import com.mkpatir.itmswikiapp.presentation.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity: BaseActivity<LoginViewModel,ActivityLoginBinding>(), LoginHandler {

    companion object{
        fun callingIntent(context: Context): Intent = Intent(context,LoginActivity::class.java).apply {

        }
    }

    override fun setLayout(): Int = R.layout.activity_login

    override fun setViewModel(): Lazy<LoginViewModel> = viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataBinding().loginHandler = this
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun loginClick(view: View) {
        val imageTransition = Pair<View,String>(appIcon,getString(R.string.image_transition))
        val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,imageTransition)
        startActivity(HomeActivity.callingIntent(this), activityOptions.toBundle())
        activityFinishAfterTransition()
    }

    override fun registerClick(view: View) {
        val imageTransition = Pair<View,String>(appIcon,getString(R.string.image_transition))
        val titleTransition = Pair<View,String>(registerButton,getString(R.string.login_screen_transition_login_to_register_title))
        val emailTransition = Pair<View,String>(loginEmail,getString(R.string.login_screen_transition_login_to_register_email))
        val passwordTransition = Pair<View,String>(loginPassword,getString(R.string.login_screen_transition_login_to_register_password))
        val buttonTransition = Pair<View,String>(loginButton,getString(R.string.login_screen_transition_login_to_register_button))
        val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,imageTransition,titleTransition,emailTransition,passwordTransition,buttonTransition)
        startActivity(RegisterActivity.callingIntent(this),activityOptions.toBundle())
    }

    override fun emailTextChange(s: CharSequence, start: Int, before: Int, count: Int) {
        getViewModel().email.set(s.toString())
        getViewModel().setButtonEnable(s.isNotBlank() && getViewModel().password.get().isNullOrBlank().not())
    }

    override fun passwordTextChange(s: CharSequence, start: Int, before: Int, count: Int) {
        getViewModel().password.set(s.toString())
        getViewModel().setButtonEnable(s.isNotBlank() && getViewModel().email.get().isNullOrBlank().not())
    }

}