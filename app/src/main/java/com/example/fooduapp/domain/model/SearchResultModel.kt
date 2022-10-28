package com.example.fooduapp.domain.model
import com.example.fooduapp.data.remote.dto.Result

data class SearchResultModel(
    val results: List<Result>,
    val offset: Long,
    val number: Long,
    val totalResults: Long,
)
