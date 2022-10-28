package com.example.fooduapp.data.remote.dto

data class CategoryRoot(
    val categories: List<Category>,
)

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
)

