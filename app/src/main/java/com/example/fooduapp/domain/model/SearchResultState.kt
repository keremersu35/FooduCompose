package com.example.fooduapp.domain.model

data class SearchResultState(
    val isLoading: Boolean = false,
    val meal: SearchResultModel? = null,
    val error: String = ""
)
