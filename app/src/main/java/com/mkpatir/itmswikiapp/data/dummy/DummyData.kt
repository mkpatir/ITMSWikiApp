package com.mkpatir.itmswikiapp.data.dummy

import com.mkpatir.itmswikiapp.data.models.response.MetricDetailResponse
import com.mkpatir.itmswikiapp.data.models.response.MetricResponse

class DummyData {

    companion object {
        fun getMetricDummyData(): ArrayList<MetricResponse>{
            val arrayList: ArrayList<MetricResponse> = arrayListOf()
            arrayList.add(
                MetricResponse(
                    "Metric goal 1",
                    "id1",
                    "Metric name 1"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 2",
                    "id2",
                    "Metric name 2"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 3",
                    "id3",
                    "Metric name 3"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 4",
                    "id4",
                    "Metric name 4"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 5",
                    "id5",
                    "Metric name 5"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 6",
                    "id6",
                    "Metric name 6"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 7",
                    "id7",
                    "Metric name 7"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 8",
                    "id8",
                    "Metric name 8"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 9",
                    "id9",
                    "Metric name 9"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 10",
                    "id10",
                    "Metric name 10"
                )
            )
            arrayList.add(
                MetricResponse(
                    "Metric goal 11",
                    "id11",
                    "Metric name 11"
                )
            )
            return arrayList
        }

        fun getMetricDetailDummyData(): ArrayList<MetricDetailResponse>{
            val arrayList: ArrayList<MetricDetailResponse> = arrayListOf()
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 1",
                    "id1",
                    "Metric Period 1",
                    "Metric Type 1",
                    "Metric Name 1"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 2",
                    "id2",
                    "Metric Period 2",
                    "Metric Type 2",
                    "Metric Name 2"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 3",
                    "id3",
                    "Metric Period 3",
                    "Metric Type 3",
                    "Metric Name 3"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 4",
                    "id4",
                    "Metric Period 4",
                    "Metric Type 4",
                    "Metric Name 4"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 5",
                    "id5",
                    "Metric Period 5",
                    "Metric Type 5",
                    "Metric Name 5"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 6",
                    "id6",
                    "Metric Period 6",
                    "Metric Type 6",
                    "Metric Name 6"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 7",
                    "id7",
                    "Metric Period 7",
                    "Metric Type 7",
                    "Metric Name 7"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 8",
                    "id8",
                    "Metric Period 8",
                    "Metric Type 8",
                    "Metric Name 8"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 9",
                    "id9",
                    "Metric Period 9",
                    "Metric Type 9",
                    "Metric Name 9"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 10",
                    "id10",
                    "Metric Period 10",
                    "Metric Type 10",
                    "Metric Name 10"
                )
            )
            arrayList.add(
                MetricDetailResponse(
                    "Metric Goal 11",
                    "id11",
                    "Metric Period 11",
                    "Metric Type 11",
                    "Metric Name 11"
                )
            )
            return arrayList
        }
    }
}