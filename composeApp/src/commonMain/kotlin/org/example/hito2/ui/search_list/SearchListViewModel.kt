package org.example.hito2.ui.search_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import io.ktor.websocket.Frame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.hito2.data.MealModel
import org.example.hito2.data.RecipeRepository

class SearchListViewModel (
    recipeRepository: RecipeRepository
) : ViewModel() {

    val objects: StateFlow<List<MealModel>> =
        recipeRepository.getRecipe()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000) , emptyList())



}


