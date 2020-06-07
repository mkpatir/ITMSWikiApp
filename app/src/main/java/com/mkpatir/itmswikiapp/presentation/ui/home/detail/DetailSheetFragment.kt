package com.mkpatir.itmswikiapp.presentation.ui.home.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.data.dummy.DummyData
import com.mkpatir.itmswikiapp.databinding.SheetFragmentDetailBinding
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseBottomSheetDialogFragment
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeActivity
import com.mkpatir.itmswikiapp.presentation.ui.home.HomeViewModel
import com.mkpatir.itmswikiapp.presentation.ui.home.addorupdatemetric.AddOrUpdateMetricSheetFragment
import kotlinx.android.synthetic.main.sheet_fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailSheetFragment: BaseBottomSheetDialogFragment<DetailViewModel,SheetFragmentDetailBinding>(), DetailHandler {

    companion object {
        private const val FRAGMENT_TAG = "DETAIL_FRAGMENT"
        private const val DETAIL_METRIC_ID = "DETAIL_METRIC_ID"

        fun showFragment(fragmentManager: FragmentManager, Id: String) {
            val bundleArgs = Bundle().apply {
                putString(DETAIL_METRIC_ID,Id)
            }
            DetailSheetFragment().apply {
                arguments = bundleArgs
            }.show(fragmentManager, FRAGMENT_TAG)
        }
    }

    private lateinit var parentViewModel: HomeViewModel

    override fun setLayout(): Int = R.layout.sheet_fragment_detail

    override fun setViewModel(): Lazy<DetailViewModel> = viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentViewModel = (activity as HomeActivity).getViewModel()
        getDataBinding().apply {
            viewModel = this@DetailSheetFragment.getViewModel()
            detailHandler = this@DetailSheetFragment
        }
        getData()
    }

    override fun update(view: View) {
        parentViewModel.showUpdateSheetFragmentLiveData.value = getViewModel().metricDetailsLiveData.value
        dismiss()
    }

    private fun getData(){
        arguments?.getString(DETAIL_METRIC_ID)?.let {
            getViewModel().getMetricDetails(it)
        }
    }
}