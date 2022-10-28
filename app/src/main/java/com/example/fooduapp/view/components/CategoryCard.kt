package com.example.fooduapp.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fooduapp.R
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun CategoryCard(title: String, imageUrl: String) {
    FooduAppTheme() {
        Column(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .wrapContentSize()) {
            Box(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(70.dp)){
                AsyncImage(model = imageUrl, contentDescription = "", modifier = Modifier.size(70.dp))
            }
            Box(modifier = Modifier.align(Alignment.CenterHorizontally), contentAlignment = Alignment.Center){
                Text(text = title, maxLines = 1, fontWeight = FontWeight.Bold, modifier = Modifier
                    .wrapContentSize(), color = MaterialTheme.colors.secondary)
            }
        }
    }
}