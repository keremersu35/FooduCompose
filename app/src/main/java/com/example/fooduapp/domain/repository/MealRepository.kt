package com.example.fooduapp.domain.repository

import com.example.fooduapp.data.remote.dto.*

interface MealRepository {

    suspend fun getRandomMeal(): RandomMealRoot
    suspend fun getCategories(): CategoryRoot
    suspend fun getMealList(): MealListDto
    suspend fun getFoodDetail(foodId: Int): FoodDetailDto
    suspend fun getSearchResults(searchQuery: String): SearchResultDto
}