package com.example.fooduapp.data.remote.dto

import com.example.fooduapp.domain.model.FoodDetailModel

data class FoodDetailDto(
    val vegetarian: Boolean,
    val vegan: Boolean,
    val glutenFree: Boolean,
    val dairyFree: Boolean,
    val veryHealthy: Boolean,
    val cheap: Boolean,
    val veryPopular: Boolean,
    val sustainable: Boolean,
    val lowFodmap: Boolean,
    val weightWatcherSmartPoints: Long,
    val gaps: String,
    val preparationMinutes: Long,
    val cookingMinutes: Long,
    val aggregateLikes: Long,
    val healthScore: Long,
    val creditsText: String,
    val license: String,
    val sourceName: String,
    val pricePerServing: Double,
    val extendedIngredients: List<ExtendedIngredient>,
    val id: Long,
    val title: String,
    val readyInMinutes: Long,
    val servings: Long,
    val sourceUrl: String,
    val image: String,
    val imageType: String,
    val summary: String,
    val cuisines: List<Any?>,
    val dishTypes: List<String>,
    val diets: List<Any?>,
    val occasions: List<Any?>,
    val winePairing: WinePairing,
    val instructions: String,
    val analyzedInstructions: List<Any?>,
    val originalId: Any?,
    val spoonacularSourceUrl: String,
)

data class WinePairing(
    val pairedWines: List<Any?>,
    val pairingText: String,
    val productMatches: List<Any?>,
)

fun FoodDetailDto.toFoodDetailModel(): FoodDetailModel{
    return FoodDetailModel(
        id = id,
        title = title,
        readyInMinutes = readyInMinutes,
        servings = servings,
        image = image,
        dishTypes = dishTypes,
        healthScore = healthScore,
        instructions = instructions,
    )
}

