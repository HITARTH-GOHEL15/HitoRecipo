package org.example.hito2.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponseModel(
    @SerialName("results")
    val meals: List<MealModel>,

    @SerialName("offset")
    val offset: Int? = 0,

    @SerialName("number")
    val number: Int? = 0,

    @SerialName("totalResults")
    val totalResults: Int? = 0

)