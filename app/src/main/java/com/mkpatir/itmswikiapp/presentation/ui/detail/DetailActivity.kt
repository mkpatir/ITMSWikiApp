package com.mkpatir.itmswikiapp.presentation.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.data.dummy.DummyData
import com.mkpatir.itmswikiapp.databinding.ActivityDetailBinding
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity: BaseActivity<DetailViewModel,ActivityDetailBinding>(), DetailHandler {

    companion object {
        fun callingIntent(context: Context,id: String) = Intent(context,DetailActivity::class.java).apply {
            putExtra(DETAIL_METRIC_ID,id)
        }

        private const val DETAIL_METRIC_ID = "detailMetricId"
    }

    override fun setLayout(): Int = R.layout.activity_detail

    override fun setViewModel(): Lazy<DetailViewModel> = viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_from_bottom,R.anim.dummy)
        getDataBinding().detailHandler = this
        assignComponents()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.dummy,R.anim.slide_to_bottom)
    }

    private fun assignComponents() {
        val dummy = DummyData.getMetricDetailDummyData().find { it.id == intent.getStringExtra(DETAIL_METRIC_ID) }
        detailName.text = dummy?.name
        detailGoal.text = dummy?.goal
        detailType.text = dummy?.measurementType
        detailPeriod.text = dummy?.measurementPeriod
    }

    override fun closeClick(view: View) {
        finish()
    }

}