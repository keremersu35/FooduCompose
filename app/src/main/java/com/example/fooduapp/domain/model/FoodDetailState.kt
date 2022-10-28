package com.example.fooduapp.domain.model

data class FoodDetailState(
    val isLoading: Boolean = false,
    val meal: FoodDetailModel? = null,
    val error: String = ""
)
