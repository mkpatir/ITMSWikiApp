package com.mkpatir.itmswikiapp.presentation.ui.home.addorupdatemetric

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.data.models.requeest.AddMetricRequest
import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import com.mkpatir.itmswikiapp.databinding.SheetFragmentAddOrUpdateMetricBinding
import com.mkpatir.itmswikiapp.internal.extention.getTextFromView
import com.mkpatir.itmswikiapp.internal.extention.isAnyTextEmpty
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseBottomSheetDialogFragment
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeActivity
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddOrUpdateMetricSheetFragment: BaseBottomSheetDialogFragment<AddOrUpdateMetricViewModel,SheetFragmentAddOrUpdateMetricBinding>(), AddOrUpdateMetricHandler {

    companion object {
        private const val FRAGMENT_TAG = "ADD_METRIC_FRAGMENT"
        private const val IS_ADD_METRIC = "IS_ADD_METRIC"
        private const val METRIC_DETAILS = "METRIC_DETAILS"

        fun showFragment(fragmentManager: FragmentManager,isAddMetric: Boolean,metricDetails: MetricDetailResponse? = null){
            val bundleArgs = Bundle().apply {
                putBoolean(IS_ADD_METRIC,isAddMetric)
                putParcelable(METRIC_DETAILS,metricDetails)
            }
            AddOrUpdateMetricSheetFragment().apply {
                arguments = bundleArgs
            }.show(fragmentManager, FRAGMENT_TAG)
        }
    }

    private lateinit var parentViewModel: HomeViewModel
    private var isAddMetric = true
    private var metricDetails: MetricDetailResponse? = null

    override fun setLayout(): Int = R.layout.sheet_fragment_add_or_update_metric

    override fun setViewModel(): Lazy<AddOrUpdateMetricViewModel> = viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentViewModel = (activity as HomeActivity).getViewModel()
        getDataBinding().apply {
            addOrUpdateMetricHandler = this@AddOrUpdateMetricSheetFragment
            viewModel = this@AddOrUpdateMetricSheetFragment.getViewModel()
        }
        setupPage()
        observeLiveData()
    }

    private fun setupPage(){
        arguments?.getBoolean(IS_ADD_METRIC)?.let {
            isAddMetric = it
            if (it){
                getViewModel().title.set(getString(R.string.add_metric_screen_title))
                getViewModel().buttonText.set(getString(R.string.add))
            }
            else {
                getViewModel().title.set(getString(R.string.update_metric_screen_title))
                getViewModel().buttonText.set(getString(R.string.update))
            }
        }
        arguments?.getParcelable<MetricDetailResponse>(METRIC_DETAILS)?.let {
            metricDetails = it
            getDataBinding().apply {
                metricName.setText(it.name)
                metricGoal.setText(it.goal)
                metricMeasurementPeriod.setText(it.measurementPeriod)
                metricMeasurementType.setText(it.measurementType)
            }
        }
    }

    private fun observeLiveData() {
        getViewModel().apply {
            addMetricLiveData.observe(viewLifecycleOwner, Observer {
                showToast(getString(R.string.add_metric_success))
                val metricList = parentViewModel.allMetricsLiveData.value
                metricList?.add(MetricResponse(it.id,it.name,it.goal))
                parentViewModel.allMetricsLiveData.value = metricList
                dismiss()
            })
            updateMetricLiveData.observe(viewLifecycleOwner, Observer {
                showToast(getString(R.string.update_metric_success))
                val metricList = parentViewModel.allMetricsLiveData.value
                metricList?.add(MetricResponse(it.id,it.name,it.goal))
                parentViewModel.allMetricsLiveData.value = metricList
                dismiss()
            })
        }
    }

    override fun addOrUpdateMetric(view: View) {
        getDataBinding().apply {
            if (isAnyTextEmpty(metricName,metricGoal,metricMeasurementType,metricMeasurementPeriod)){
                showToast(getString(R.string.empty_field_error))
            }
            else {
                if (isAddMetric){
                    this@AddOrUpdateMetricSheetFragment.getViewModel().addMetric(AddMetricRequest(
                        getTextFromView(metricGoal),
                        getTextFromView(metricMeasurementPeriod),
                        getTextFromView(metricMeasurementType),
                        getTextFromView(metricName)
                    ))
                }
                else {
                    this@AddOrUpdateMetricSheetFragment.getViewModel().updateMetric(
                        metricDetails?.id.orEmpty(),
                        AddMetricRequest(
                        getTextFromView(metricGoal),
                        getTextFromView(metricMeasurementPeriod),
                        getTextFromView(metricMeasurementType),
                        getTextFromView(metricName)
                    ))
                }
            }
        }
    }

}