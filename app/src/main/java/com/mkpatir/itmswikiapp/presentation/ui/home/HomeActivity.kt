package com.mkpatir.itmswikiapp.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.data.dummy.DummyData
import com.mkpatir.itmswikiapp.databinding.ActivityHomeBinding
import com.mkpatir.itmswikiapp.internal.extention.gone
import com.mkpatir.itmswikiapp.internal.extention.isVisible
import com.mkpatir.itmswikiapp.internal.extention.visible
import com.mkpatir.itmswikiapp.presentation.ui.base.BaseActivity
import com.mkpatir.itmswikiapp.presentation.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity: BaseActivity<HomeViewModel,ActivityHomeBinding>() {

    companion object {
        fun callingIntent(context: Context) = Intent(context,HomeActivity::class.java).apply {

        }
    }

    private var metricsAdapter = MetricsAdapter(arrayListOf())
    private var scrollCount = -1

    override fun setLayout(): Int = R.layout.activity_home

    override fun setViewModel(): Lazy<HomeViewModel> = viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeComponents()
    }

    private fun initializeComponents() {
        homeRecyclerView.layoutManager = LinearLayoutManager(this)
        homeRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            val collapse = this@HomeActivity.resources.getDimension(R.dimen.home_screen_scroll_collapse)
            val expand = this@HomeActivity.resources.getDimension(R.dimen.home_screen_scroll_expand)
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                scrollCount += dy
                if (dy > 0 && scrollCount > collapse && homeCardViewText.isVisible()){
                    homeCardViewText.gone()
                }
                if (dy < 0 && scrollCount < expand && homeCardViewText.isVisible().not()){
                    homeCardViewText.visible()
                }
            }
        })
        homeRecyclerView.adapter = metricsAdapter
        metricsAdapter.assignInitialValues(DummyData.getMetricDummyData())
        metricsAdapter.itemClickListener = {
            startActivity(DetailActivity.callingIntent(this,it))
        }
        homeCardViewTotalCount.text = DummyData.getMetricDummyData().size.toString()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}