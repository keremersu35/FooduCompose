package com.example.fooduapp.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.fooduapp.ui.theme.FooduAppTheme
import com.example.fooduapp.view.Screens

@Composable
fun RandomMeal(text: String, imageUrl: String, color: Color, modifier: Modifier, isLoading: Boolean, navController: NavController, id: Int) {
    FooduAppTheme() {
        if(!isLoading){
            Box(modifier = modifier
                .background(color)
                .clip(RoundedCornerShape(15.dp))
                .clickable { navController.navigate("${Screens.FoodDetailPage.route}/$id") }) {
                Row() {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = text,
                            fontWeight = FontWeight.Bold,
                            fontSize = 38.sp,
                            color = Color.White,
                            maxLines = 3,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(
                                Alignment.CenterHorizontally
                            )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(15.dp))
                            .fillMaxHeight()
                    ) {
                        AsyncImage(
                            model = imageUrl,
                            contentDescription = "",
                            modifier = Modifier.fillMaxHeight(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }else{
            Box(modifier = modifier
                .background(color)
                .clip(RoundedCornerShape(15.dp))) {

                CircularProgressIndicator(color = Color.White, modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}