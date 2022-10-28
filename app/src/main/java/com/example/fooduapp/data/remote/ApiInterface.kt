package com.example.fooduapp.data.remote

import com.example.fooduapp.common.Constants
import com.example.fooduapp.data.remote.dto.*
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET(Constants.RANDOM_MEAL_URL)
    suspend fun getRandomMeal(@Header("x-api-key") apiKey: String, @Header("Content-Type") contentType: String): RandomMealRoot

    @GET(Constants.CATEGORIES_URL)
    suspend fun getCategories(@Header("x-api-key") apiKey: String, @Header("Content-Type") contentType: String): CategoryRoot

    @GET(Constants.LIST_URL)
    suspend fun getMealList(@Header("x-api-key") apiKey: String, @Header("Content-Type") contentType: String): MealListDto

    @GET(Constants.FOOD_DETAIL_URL)
    suspend fun getFoodDetail(@Header("x-api-key") apiKey: String, @Header("Content-Type") contentType: String, @Path("id") mealId: Int): FoodDetailDto

    @GET(Constants.SEARCH_URL)
    suspend fun getSearchResults(@Header("x-api-key") apiKey: String, @Header("Content-Type") contentType: String, @Query("query") query: String): SearchResultDto

}