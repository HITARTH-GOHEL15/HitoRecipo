package org.example.hito2.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.json.json
import org.example.hito2.data.InMemoryRecipeStorage
import org.example.hito2.data.KtorRecipeApi
import org.example.hito2.data.RecipeApi
import org.example.hito2.data.RecipeRepository
import org.example.hito2.data.RecipeStorage
import org.example.hito2.ui.detail.RecipeDetailViewModel
import org.example.hito2.ui.search_list.SearchListViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module


val dataModule = module {
    single {
        val json = Json {
            ignoreUnknownKeys = true
        }
        HttpClient {
            install(ContentNegotiation) {
                json(json , contentType = ContentType.Any)
            }
        }
    }

    single<RecipeApi> {
        KtorRecipeApi(get())
    }
    single<RecipeStorage> {
        InMemoryRecipeStorage()
    }
    single {
        RecipeRepository(get() , get()).apply {
            initialize()
        }
    }
}

val viewModelModule = module {
    factoryOf(::SearchListViewModel)
    factoryOf(::RecipeDetailViewModel)
}

fun initKoin() {
    startKoin {
        modules(dataModule , viewModelModule)
    }
}