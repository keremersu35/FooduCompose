package com.example.fooduapp.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun SmallCategoryList(modifier: Modifier) {
    FooduAppTheme() {
        LazyRow(modifier = modifier) {
            items((1..5).toList()){
                Box(modifier = Modifier.padding(horizontal = 3.dp)) {
                    SmallCategoryCard("Hamburger")
                }
            }
        }
    }
}