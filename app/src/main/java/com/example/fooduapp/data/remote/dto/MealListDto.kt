package com.example.fooduapp.data.remote.dto

import com.example.fooduapp.domain.model.MealListModel

data class MealListDto(
    val results: List<ResultModel>,
    val offset: Long,
    val number: Long,
    val totalResults: Long,
)

data class ResultModel(
    val id: Long,
    val title: String,
    val image: String,
    val imageType: String,
)

fun MealListDto.toMealListModel(): MealListModel {
    return MealListModel(
        results = results
    )
}
