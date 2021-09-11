package com.ziyaad.meal_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.ziyaad.meal_app.ui.details.MealDetailsScreen
import com.ziyaad.meal_app.ui.details.MealDetailsViewModel
import com.ziyaad.meal_app.ui.meals.MealCategoriesScreen
import com.ziyaad.meal_app.ui.theme.MealappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MealappTheme {
                FoodzApp()
            }
        }
    }
}

@Composable
private fun FoodzApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destination_meals_lists") {
        composable(route = "destination_meals_lists") {
            MealCategoriesScreen(){ navigationMealId ->
                navController.navigate("destination_meals_details/$navigationMealId")
            }
        }

        composable(
            route = "destination_meals_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailsScreen(viewModel.mealState.value)
        }
    }
}

