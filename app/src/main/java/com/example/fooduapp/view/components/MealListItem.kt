package com.example.fooduapp.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.fooduapp.R
import com.example.fooduapp.ui.theme.FooduAppTheme
import com.example.fooduapp.ui.theme.Orange
import com.example.fooduapp.view.Screens

@Composable
fun MealListItem(title: String, description: String, imageUrl: String, navController: NavController, id: Long) {
    FooduAppTheme() {
        Row(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(5.dp)
            .height(120.dp)
            .clickable { navController.navigate("${Screens.FoodDetailPage.route}/$id") }) {
            println(id)
            AsyncImage(model = imageUrl, contentDescription = "", modifier = Modifier
                .clip(
                    RoundedCornerShape(15.dp)
                )
                .weight(0.4f))
            Column(modifier = Modifier
                .weight(0.6f)
                .padding(start = 10.dp)
                .fillMaxHeight()) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp, maxLines = 1, modifier = Modifier.weight(1f), color = MaterialTheme.colors.secondary)
                Row(modifier = Modifier.weight(1f)) {
                    Text(text = "800 m | ", fontSize = 12.sp, color = MaterialTheme.colors.secondary)
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "", tint = Orange, modifier = Modifier.size(15.dp))
                    Text(text = " 4.9 ", fontSize = 12.sp, color = MaterialTheme.colors.secondary)
                    Text(text = "(2.3k)", fontSize = 12.sp, color = MaterialTheme.colors.secondary)
                }
                Row(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(end = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Row() {
                        Icon(painter = painterResource(id = R.drawable.motor), contentDescription = "", modifier= Modifier.size(20.dp), tint = MaterialTheme.colors.primary)
                        Text(text = "  $2.00", color = MaterialTheme.colors.secondary)
                    }
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "", tint = Color.Gray)
                }
            }
        }
    }
}