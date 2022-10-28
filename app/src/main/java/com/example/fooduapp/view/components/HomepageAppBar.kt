package com.example.fooduapp.view.components

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooduapp.R
import com.example.fooduapp.ui.theme.FooduAppTheme

@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomepageAppBar() {
    FooduAppTheme() {
        var expanded by remember { mutableStateOf(false) }
        val context = LocalContext.current

        Row(modifier = Modifier.background(MaterialTheme.colors.background), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .weight(0.2f)
                .padding(10.dp)
                .clip(RoundedCornerShape(25.dp))) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
                )
            }

            Column(modifier = Modifier
                .weight(0.8f)
                .fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                Text(text = "Deliver To", fontWeight = FontWeight.Light, fontSize = 13.sp, color = MaterialTheme.colors.secondary)

            }

            Row(modifier = Modifier.weight(0.3f)){
                Box(modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(MaterialTheme.colors.background)
                    .border(
                        BorderStroke(0.5.dp, color = MaterialTheme.colors.secondary),
                        RoundedCornerShape(25.dp)
                    )){
                    Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "", modifier = Modifier.padding(5.dp), tint = MaterialTheme.colors.secondary)
                }

                Box(modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(MaterialTheme.colors.background)
                    .border(
                        BorderStroke(0.5.dp, color = MaterialTheme.colors.secondary),
                        RoundedCornerShape(25.dp)
                    )){
                    Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "", modifier = Modifier.padding(5.dp), tint = MaterialTheme.colors.secondary)
                }
            }
        }
    }
}

