package org.example.hito2.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.hito2.data.model.ExtendedIngredientModel

@Serializable
data class MealModel(
    @SerialName("aggregateLikes")
    val aggregateLikes: Int? = 0,
    @SerialName("cheap")
    val cheap: Boolean? = false,
    @SerialName("creditsText")
    val creditsText: String? = "",
    @SerialName("dairyFree")
    val dairyFree: Boolean? = false,
    @SerialName("diets")
    val diets: List<String?>? = listOf(),
    @SerialName("dishTypes")
    val dishTypes: List<String?>? = listOf(),
    @SerialName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredientModel?>? = listOf(),
    @SerialName("gaps")
    val gaps: String? = "",
    @SerialName("glutenFree")
    val glutenFree: Boolean? = false,
    @SerialName("healthScore")
    val healthScore: Double? = 0.0,
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("image")
    val image: String? = "",
    @SerialName("imageType")
    val imageType: String? = "",
    @SerialName("lowFodmap")
    val lowFodmap: Boolean? = false,
    @SerialName("pricePerServing")
    val pricePerServing: Double? = 0.0,
    @SerialName("readyInMinutes")
    val readyInMinutes: Int? = 0,
    @SerialName("servings")
    val servings: Int? = 0,
    @SerialName("sourceName")
    val sourceName: String? = "",
    @SerialName("sourceUrl")
    val sourceUrl: String? = "",
    @SerialName("spoonacularScore")
    val spoonacularScore: Double? = 0.0,
    @SerialName("summary")
    val summary: String? = "",
    @SerialName("sustainable")
    val sustainable: Boolean? = false,
    @SerialName("title")
    val title: String? = "",
    @SerialName("vegan")
    val vegan: Boolean? = false,
    @SerialName("vegetarian")
    val vegetarian: Boolean? = false,
    @SerialName("veryHealthy")
    val veryHealthy: Boolean? = false,
    @SerialName("veryPopular")
    val veryPopular: Boolean? = false,
    @SerialName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int? = 0
)