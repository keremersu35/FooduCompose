package com.example.fooduapp.view

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooduapp.base.BaseView
import com.example.fooduapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(key1 = true) {
        delay(500L)
        navController.navigate(Screens.OnBoarding.route)
    }

    Column() {
        BaseView(canScroll = false, content = {
            Row(
                modifier = Modifier
                    .weight(0.9f)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foodu_logo),
                    contentDescription = "",
                    modifier = Modifier
                        .align(
                            Alignment.CenterVertically
                        )
                        .size(80.dp)
                        .padding(8.dp)
                )
                Text(
                    text = "Foodu", modifier = Modifier.align(
                        Alignment.CenterVertically
                    ),
                    color = MaterialTheme.colors.secondary,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            CircularProgressIndicator(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterHorizontally), color = Color.Green
            )

            Spacer(modifier = Modifier.height(25.dp))
        })
    }
}