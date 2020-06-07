package com.mkpatir.itmswikiapp.presentation.ui.home.addmetric

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.data.models.requeest.AddMetricRequest
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import com.mkpatir.itmswikiapp.databinding.SheetFragmentAddMetricBinding
import com.mkpatir.itmswikiapp.internal.extention.getTextFromView
import com.mkpatir.itmswikiapp.internal.extention.isAnyTextEmpty
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseBottomSheetDialogFragment
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeActivity
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddMetricSheetFragment: BaseBottomSheetDialogFragment<AddMetricViewModel,SheetFragmentAddMetricBinding>(), AddMetricHandler {

    companion object {
        private const val FRAGMENT_TAG = "ADD_METRIC_FRAGMENT"

        fun showFragment(fragmentManager: FragmentManager){
            AddMetricSheetFragment().show(fragmentManager, FRAGMENT_TAG)
        }
    }

    private lateinit var parentViewModel: HomeViewModel

    override fun setLayout(): Int = R.layout.sheet_fragment_add_metric

    override fun setViewModel(): Lazy<AddMetricViewModel> = viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentViewModel = (activity as HomeActivity).getViewModel()
        getDataBinding().apply {
            addMetricHandler = this@AddMetricSheetFragment
            viewModel = this@AddMetricSheetFragment.getViewModel()
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        getViewModel().apply {
            addMetricLiveData.observe(viewLifecycleOwner, Observer {
                val metricList = parentViewModel.allMetricsLiveData.value
                metricList?.add(MetricResponse(it.id,it.name,it.goal))
                parentViewModel.allMetricsLiveData.value = metricList
                dismiss()
            })
        }
    }

    override fun addMetric(view: View) {
        getDataBinding().apply {
            if (isAnyTextEmpty(metricName,metricGoal,metricMeasurementType,metricMeasurementPeriod)){
                showToast(getString(R.string.empty_field_error))
            }
            else {
                this@AddMetricSheetFragment.getViewModel().addMetric(AddMetricRequest(
                    getTextFromView(metricGoal),
                    getTextFromView(metricMeasurementPeriod),
                    getTextFromView(metricMeasurementType),
                    getTextFromView(metricName)
                ))
            }
        }
    }

}