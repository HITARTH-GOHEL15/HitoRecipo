package org.example.hito2.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RecipeRepository(
    private val recipeApi: RecipeApi,
    private val recipeStorage: RecipeStorage
) {
    private val scope = CoroutineScope(SupervisorJob())

    fun initialize() {
        scope.launch {
            refresh()
        }
    }

    suspend fun refresh() {
        recipeStorage.saveObjects(recipeApi.getData())
    }

    fun getRecipe(): Flow<List<MealModel>> = recipeStorage.getRecipe()

    fun getRecipeById(recipeId: Int): Flow<MealModel?> = recipeStorage.getRecipeById(recipeId)
}