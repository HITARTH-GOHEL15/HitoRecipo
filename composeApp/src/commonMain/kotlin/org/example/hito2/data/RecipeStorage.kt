package org.example.hito2.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface RecipeStorage {
    suspend fun saveObjects(newObjects: List<MealModel>)

    fun getRecipeById(RecipeId : Int):  Flow<MealModel?>

    fun getRecipe() : Flow<List<MealModel>>

}

class InMemoryRecipeStorage : RecipeStorage {

    private val storageRecipes = MutableStateFlow(emptyList<MealModel>())


    override suspend fun saveObjects(newObjects: List<MealModel>) {
        storageRecipes.value = newObjects
    }

    override fun getRecipeById(recipeId: Int): Flow<MealModel?> {
        return storageRecipes.map { recipe ->
            recipe.find { it.id.toString() == recipeId.toString() }
        }
    }

    override fun getRecipe(): Flow<List<MealModel>> = storageRecipes

}