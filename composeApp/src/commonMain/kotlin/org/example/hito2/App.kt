package org.example.hito2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.example.hito2.core.HITO_2Theme
import org.example.hito2.ui.HomeScreen
import org.example.hito2.ui.detail.RecipeDetailScreen
import org.example.hito2.ui.search_list.SearchListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Serializable
object ListDestination

@Serializable
data class DetailDestination(val objectId: Int)

@Composable
@Preview
fun App() {
    HITO_2Theme {
        val navController: NavHostController = rememberNavController()
        NavHost(navController = navController,  startDestination = ListDestination) {
            composable<ListDestination> {
                HomeScreen(
                    navigateToDetails = { recipeId ->
                        navController.navigate(DetailDestination(recipeId))
                    }
                )
            }
            composable<DetailDestination> { navBackStackEntry ->
                RecipeDetailScreen(
                    recipeId = navBackStackEntry.toRoute<DetailDestination>().objectId
                )
            }
        }
    }
}