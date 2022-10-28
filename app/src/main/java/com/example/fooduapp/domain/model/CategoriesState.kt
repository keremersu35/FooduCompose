package com.example.fooduapp.domain.model

import com.example.fooduapp.data.remote.dto.CategoryRoot

data class CategoriesState(
    val isLoading: Boolean = false,
    val meal: CategoryRoot? = null,
    val error: String = ""
)