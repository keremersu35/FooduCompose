package com.example.fooduapp.domain.model

data class MealListState(
    val isLoading: Boolean = false,
    val meal: MealListModel? = null,
    val error: String = ""
)
