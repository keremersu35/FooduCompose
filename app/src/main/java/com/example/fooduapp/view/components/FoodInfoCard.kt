package com.example.fooduapp.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.fooduapp.base.BaseView
import com.example.fooduapp.base.BaseWidget
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun FoodInfoCard(icon: ImageVector, title: String, modifier: Modifier) {
    FooduAppTheme() {
        Row(modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.primary)
            .border(BorderStroke(1.dp, MaterialTheme.colors.secondary), RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
        {
            Icon(imageVector = icon, contentDescription = "", modifier = Modifier
                .size(25.dp))
            Text(text = title, modifier = Modifier.padding(start = 10.dp))
        }
    }
}