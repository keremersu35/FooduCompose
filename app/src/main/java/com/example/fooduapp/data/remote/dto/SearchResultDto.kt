package com.example.fooduapp.data.remote.dto

import com.example.fooduapp.domain.model.SearchResultModel

data class SearchResultDto(
    val results: List<Result>,
    val offset: Long,
    val number: Long,
    val totalResults: Long,
)

data class Result(
    val id: Long,
    val title: String,
    val image: String,
    val imageType: String,
)

fun SearchResultDto.toSearchResultModel(): SearchResultModel {
    return SearchResultModel(
        results = results,
        offset = offset,
        number = number,
        totalResults = totalResults
    )
}
