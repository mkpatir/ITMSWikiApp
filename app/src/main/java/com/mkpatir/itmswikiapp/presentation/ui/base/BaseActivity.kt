package com.mkpatir.itmswikiapp.presentation.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VM: BaseViewModel, D: ViewDataBinding>: AppCompatActivity() {

    private lateinit var dataBinding: D
    private lateinit var viewModel: VM
    private var activityFinishAfterTransitionFlag = false

    abstract fun setLayout(): Int

    abstract fun setViewModel(): Lazy<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,setLayout())
        viewModel = setViewModel().value
    }

    override fun onResume() {
        super.onResume()
        if (activityFinishAfterTransitionFlag){
            finish()
        }
    }

    override fun onStop() {
        super.onStop()
        if (activityFinishAfterTransitionFlag){
            finish()
        }
    }

    fun getViewModel() = setViewModel().value

    fun getDataBinding() = dataBinding

    fun alertWithAction(message: String,buttonText: String, action: () -> Unit){

    }

    fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    fun activityFinishAfterTransition(){
        activityFinishAfterTransitionFlag = true
    }
}