package org.example.hito2.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.hito2.ui.search_list.SearchListScreen
import org.example.hito2.ui.search_list.SearchListViewModel
import org.example.hito2.ui.search_list.components.SearchBar
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToDetails: (recipeId: Int) -> Unit
) {

    var searchSwitch by remember {
        mutableStateOf(false)
    }

    var bottomNavigationScreens by rememberSaveable {
        mutableStateOf(BottomNavigationScreens.SearchScreenView)
    }

    val viewModel = koinViewModel<SearchListViewModel>()
    val recipes by viewModel.objects.collectAsStateWithLifecycle()
    var searchQuery by rememberSaveable { mutableStateOf("") }

    val filteredRecipe by remember(searchQuery) {
        derivedStateOf {
            val recipeList = recipes
            if(searchQuery.isNotBlank()) {
                recipeList.filter { it.title?.contains(searchQuery , ignoreCase = true) == true }
            } else {
                recipeList
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(!searchSwitch) {
                        Text(
                            text = "HitoRecipo",
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 25.sp
                        )
                    }
                    //Search - icon
                    if(searchSwitch) {
                        SearchBar(
                            searchQuery = searchQuery,
                            onSearchQueryChange = {
                                searchQuery = it
                            },
                            modifier = Modifier
                                .padding(top = 12.dp)
                        )
                    }
                },
                navigationIcon = {
                    if(searchSwitch) {
                        IconButton(
                            onClick = {
                                searchSwitch = false
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Arrow",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                },
                actions = {
                    if(!searchSwitch) {
                        IconButton(
                            onClick = {
                                searchSwitch = true
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                          },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) {
        SearchListScreen(
            recipes = filteredRecipe,
            modifier = Modifier,
            navigateToDetails = navigateToDetails
        )
    }
}



private enum class BottomNavigationScreens{
    SearchScreenView,
    FavoriteScreenView
}