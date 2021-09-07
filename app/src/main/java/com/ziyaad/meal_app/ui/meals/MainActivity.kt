package com.ziyaad.meal_app.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ziyaad.meal_app.ui.theme.MealappTheme

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

    Text(text = "Hello Compose!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealappTheme {
        MealCategoriesScreen("Hello Compose!")
    }
}