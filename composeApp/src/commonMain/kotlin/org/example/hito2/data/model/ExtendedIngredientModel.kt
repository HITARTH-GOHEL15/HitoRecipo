package org.example.hito2.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtendedIngredientModel(
    @SerialName("aisle")
    val aisle: String? = "",
    @SerialName("amount")
    val amount: Double? = 0.0,
    @SerialName("consistency")
    val consistency: String? = "",
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("image")
    val image: String? = "",
    @SerialName("measures")
    val measures: MeasuresModel? = MeasuresModel(),
    @SerialName("meta")
    val meta: List<String?>? = listOf(),
    @SerialName("name")
    val name: String? = "",
    @SerialName("nameClean")
    val nameClean: String? = "",
    @SerialName("original")
    val original: String? = "",
    @SerialName("originalName")
    val originalName: String? = "",
    @SerialName("unit")
    val unit: String? = ""
)