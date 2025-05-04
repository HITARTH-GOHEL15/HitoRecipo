package org.example.hito2.ui.detail

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.hito2.ui.components.CircularIndicator
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RecipeDetailScreen(
    recipeId: Int
) {
    val viewModel = koinViewModel<RecipeDetailViewModel>()
    val recipe by viewModel.getObject(recipeId).collectAsStateWithLifecycle(initialValue = null)

    AnimatedContent(
        recipe != null
    ) { recipeAvailable ->
        if(recipeAvailable) {
            RecipeDetails(recipe!!)
        } else {
            CircularIndicator()
        }

    }
}