package org.example.hito2.ui.search_list

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.hito2.data.MealModel
import org.example.hito2.ui.components.CircularIndicator
import org.example.hito2.ui.search_list.components.SearchListCard

@Composable
fun SearchListScreen(
    modifier: Modifier,
    navigateToDetails: (recipeId: Int) -> Unit,
    recipes: List<MealModel>
) {

    AnimatedContent(
        recipes.isNotEmpty()
    ) { recipesAvailable ->
        if(recipesAvailable) {
            SearchList(
                recipes = recipes,
                onRecipeClick = navigateToDetails
            )
        } else {
            CircularIndicator(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun SearchList(
    recipes: List<MealModel>,
    onRecipeClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 80.dp , bottom = 20.dp),
        contentPadding = WindowInsets.safeDrawing.asPaddingValues()
    ) {
        items(recipes , key = {it.id.toString()}) { recipe ->
            SearchListCard(
                recipe = recipe,
                onRecipeClick = {
                    recipe.id?.let { onRecipeClick(it) }
                }
            )
        }
    }
}