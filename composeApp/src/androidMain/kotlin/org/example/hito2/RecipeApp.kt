package org.example.hito2

import android.app.Application
import org.example.hito2.di.initKoin

class RecipeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}