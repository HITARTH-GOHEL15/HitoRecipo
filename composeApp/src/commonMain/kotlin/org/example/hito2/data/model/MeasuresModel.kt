package org.example.hito2.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeasuresModel(
    @SerialName("metric")
    val metric: MetricModel? = MetricModel(),
    @SerialName("us")
    val us: UsModel? = UsModel()
)