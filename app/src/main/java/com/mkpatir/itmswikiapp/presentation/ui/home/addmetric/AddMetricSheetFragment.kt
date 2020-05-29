package com.mkpatir.itmswikiapp.presentation.ui.home.addmetric

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.databinding.SheetFragmentAddMetricBinding
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseBottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddMetricSheetFragment: BaseBottomSheetDialogFragment<AddMetricViewModel,SheetFragmentAddMetricBinding>(), AddMetricHandler {

    companion object {
        private const val FRAGMENT_TAG = "ADD_METRIC_FRAGMENT"

        fun showFragment(fragmentManager: FragmentManager){
            AddMetricSheetFragment().show(fragmentManager, FRAGMENT_TAG)
        }
    }

    override fun setLayout(): Int = R.layout.sheet_fragment_add_metric

    override fun setViewModel(): Lazy<AddMetricViewModel> = viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataBinding().addMetricHandler = this
    }

    override fun addMetric(view: View) {
        showToast("Add Metric")
    }

}