package com.example.fooduapp.domain.model

data class FoodDetailModel(
    val id: Long,
    val title: String,
    val readyInMinutes: Long,
    val servings: Long,
    val image: String,
    val dishTypes: List<String>,
    val healthScore: Long,
    val instructions: String,
)
