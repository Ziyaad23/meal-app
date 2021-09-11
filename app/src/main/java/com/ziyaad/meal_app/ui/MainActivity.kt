package com.ziyaad.meal_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ziyaad.meal_app.ui.meals.MealCategoriesScreen
import com.ziyaad.meal_app.ui.theme.MealappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MealappTheme {
                MealCategoriesScreen()
            }
        }
    }
}

