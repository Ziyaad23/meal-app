package com.ziyaad.meal_app.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ziyaad.meal_app.ui.model.response.MealResponse
import com.ziyaad.meal_app.ui.theme.MealappTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MealappTheme {
                MealCategoriesScreen("Android")
            }
        }
    }
}

@Composable
fun MealCategoriesScreen(name: String) {
    //Bind viewModel to composable
    val viewModel: MealsCategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>())}
    val coroutineScope = rememberCoroutineScope()

    //Launches only once
    LaunchedEffect(key1 = "GET_MEALS"){
        coroutineScope.launch(Dispatchers.IO){
            val meals = viewModel.getMeals()
            rememberedMeals.value = meals
        }
    }

    LazyColumn {
        items(rememberedMeals.value){ meal ->
            Text(text = meal.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealappTheme {
        MealCategoriesScreen("Hello Compose!")
    }
}