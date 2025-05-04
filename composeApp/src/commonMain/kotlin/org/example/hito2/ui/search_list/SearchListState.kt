package org.example.hito2.ui.search_list

import org.example.hito2.data.MealModel

data class SearchListState(
    val searchText: String = "",
    val recpies: List<MealModel> = emptyList(),
    val filteredRecipes: List<MealModel> = emptyList()
)