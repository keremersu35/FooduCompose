package com.example.fooduapp.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.fooduapp.R
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun SmallCategoryCard(title: String) {
    FooduAppTheme() {
        Row(modifier = Modifier
            .wrapContentSize()
            .border(BorderStroke(1.dp, MaterialTheme.colors.primary), RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.background)
            .padding(vertical = 3.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.categories), contentDescription = "", modifier = Modifier.size(25.dp))
            Text(text = title, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(5.dp), color = MaterialTheme.colors.secondary)
        }
    }
}