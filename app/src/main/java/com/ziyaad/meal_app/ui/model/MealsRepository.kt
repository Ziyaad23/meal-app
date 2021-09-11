package com.ziyaad.meal_app.ui.model

import com.ziyaad.meal_app.ui.model.api.MealsWebService
import com.ziyaad.meal_app.ui.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}