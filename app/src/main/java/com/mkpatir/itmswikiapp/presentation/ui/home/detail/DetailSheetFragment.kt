package com.mkpatir.itmswikiapp.presentation.ui.home.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.data.dummy.DummyData
import com.mkpatir.itmswikiapp.databinding.SheetFragmentDetailBinding
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseBottomSheetDialogFragment
import kotlinx.android.synthetic.main.sheet_fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailSheetFragment: BaseBottomSheetDialogFragment<DetailViewModel,SheetFragmentDetailBinding>() {

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

    override fun setLayout(): Int = R.layout.sheet_fragment_detail

    override fun setViewModel(): Lazy<DetailViewModel> = viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        assignComponents()

    }

    private fun assignComponents() {
        val dummy = DummyData.getMetricDetailDummyData().find { it.id == arguments?.getString(DETAIL_METRIC_ID) }
        detailName.text = dummy?.name
        detailGoal.text = dummy?.goal
        detailType.text = dummy?.measurementType
        detailPeriod.text = dummy?.measurementPeriod
    }
}