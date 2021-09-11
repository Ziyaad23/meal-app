package com.ziyaad.meal_app.ui.meals

import androidx.lifecycle.ViewModel
import com.ziyaad.meal_app.ui.model.MealsRepository
import com.ziyaad.meal_app.ui.model.response.MealResponse

class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel(){
    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}