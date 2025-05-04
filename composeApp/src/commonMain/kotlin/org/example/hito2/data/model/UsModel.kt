package org.example.hito2.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsModel(
    @SerialName("amount")
    val amount: Double? = 0.0,
    @SerialName("unitLong")
    val unitLong: String? = "",
    @SerialName("unitShort")
    val unitShort: String? = ""
)