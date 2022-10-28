package com.example.fooduapp.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fooduapp.R
import com.example.fooduapp.data.remote.dto.CategoryRoot
import com.example.fooduapp.domain.model.CategoriesModel
import com.example.fooduapp.model.CategoryCardModel
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun HomepageGridLayout(modifier : Modifier, categoryList: CategoryRoot?, isLoading: Boolean) {
    FooduAppTheme() {
        if (!isLoading) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                contentPadding = PaddingValues(8.dp),
                userScrollEnabled = false,
                modifier = modifier
            ) {
                items(categoryList!!.categories.size) { item ->
                    CategoryCard(
                        categoryList.categories[item].strCategory,
                        categoryList.categories[item].strCategoryThumb
                    )
                }
            }
        }else{
            Box(modifier = modifier){
                CircularProgressIndicator(color = MaterialTheme.colors.secondary)
            }
        }
    }
}