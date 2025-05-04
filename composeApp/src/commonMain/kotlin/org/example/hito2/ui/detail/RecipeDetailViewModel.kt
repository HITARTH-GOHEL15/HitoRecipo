package org.example.hito2.ui.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import org.example.hito2.data.MealModel
import org.example.hito2.data.RecipeRepository

class RecipeDetailViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    fun getObject(
        objectId: Int
    ): Flow<MealModel?> = recipeRepository.getRecipeById(objectId)
}