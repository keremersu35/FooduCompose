package com.example.fooduapp.data.repository

import com.example.fooduapp.data.remote.ApiInterface
import com.example.fooduapp.data.remote.dto.*
import com.example.fooduapp.domain.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val api: ApiInterface): MealRepository
{

    override suspend fun getRandomMeal(): RandomMealRoot {
        return api.getRandomMeal("51589908238e417594cb5f2f01b8727b","application/json")
    }

    override suspend fun getCategories(): CategoryRoot {
        return api.getCategories("51589908238e417594cb5f2f01b8727b","application/json")
    }

    override suspend fun getMealList(): MealListDto {
        return api.getMealList("51589908238e417594cb5f2f01b8727b","application/json")
    }

    override suspend fun getFoodDetail(mealId: Int): FoodDetailDto {
        return api.getFoodDetail("51589908238e417594cb5f2f01b8727b","application/json", mealId)
    }

    override suspend fun getSearchResults(searchQuery: String): SearchResultDto {
        return api.getSearchResults("51589908238e417594cb5f2f01b8727b","application/json", searchQuery)
    }
}