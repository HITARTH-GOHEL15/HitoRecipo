package org.example.hito2.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CancellationException

interface RecipeApi {
    suspend fun getData(): List<MealModel>
}
var offset = 0
val limit = 100

class KtorRecipeApi(private val client: HttpClient) : RecipeApi {
    companion object {
        private const val API_URL =
            "https://api.spoonacular.com/recipes/complexSearch?&number=500&addRecipeInformation=true&apiKey=dee92152b78b4a268efac33bc42bd8a5"
    }
    override suspend fun getData(): List<MealModel> {
        return try {
            val response: RecipeResponseModel = client.get(API_URL).body()
            response.meals ?: emptyList()
        } catch (e: Exception) {
            if(e is CancellationException) throw e
            e.printStackTrace()
            emptyList()
        }
    }
}