package com.mkpatir.itmswikiapp.presentation.ui.home

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mkpatir.itmswikiapp.R
import com.mkpatir.itmswikiapp.data.models.response.MetricResponse
import kotlinx.android.synthetic.main.row_metric.view.*

class MetricsAdapter(private var itemList: ArrayList<MetricResponse>): RecyclerView.Adapter<MetricsAdapter.MetricViewHolder>() {

    internal var itemClickListener: (String) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MetricViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_metric,parent,false)
        return MetricViewHolder(itemView)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: MetricViewHolder, position: Int) {
        holder.bind(itemList[position],position)
    }

    inner class MetricViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(metricResponse: MetricResponse, position: Int){
            itemView.rowMetricName.text = metricResponse.name
            itemView.rowMetricGoal.text = metricResponse.goal
            when {
                position %3 == 0 -> {
                    itemView.rowMetricLeftLine.background = ColorDrawable(ContextCompat.getColor(itemView.context,R.color.colorPrimaryDark))
                }
                position %3 == 1 -> {
                    itemView.rowMetricLeftLine.background = ColorDrawable(ContextCompat.getColor(itemView.context,R.color.colorPrimary))
                }
                else -> {
                    itemView.rowMetricLeftLine.background = ColorDrawable(ContextCompat.getColor(itemView.context,R.color.colorAccent))
                }
            }
            itemView.setOnClickListener {
                itemClickListener(metricResponse.id)
            }
        }
    }

    fun assignInitialValues(itemList: ArrayList<MetricResponse>){
        this.itemList = itemList
        notifyDataSetChanged()
    }
}