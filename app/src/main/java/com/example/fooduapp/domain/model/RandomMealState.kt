package com.example.fooduapp.domain.model

data class RandomMealState(
    val isLoading: Boolean = false,
    val meal: RandomMealModel? = null,
    val error: String = ""
)
