package com.ziyaad.meal_app.ui.meals

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ziyaad.meal_app.ui.model.MealsRepository
import com.ziyaad.meal_app.ui.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository.getInstance()): ViewModel(){

    init {
        Log.d("TAG_COROUTINES", "we are about to launch a coroutine") // 1
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINES", "we have launched the coroutine") // 1
            val meals = getMeals()
            Log.d("TAG_COROUTINES", "we have received the async data") // 1
            mealState.value = meals
        }
        Log.d("TAG_COROUTINES", "other work") // 2
    }

    val mealState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}