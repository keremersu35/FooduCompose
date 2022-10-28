package com.example.fooduapp.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.AddLocation
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooduapp.base.BaseWidget
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun CustomAppBar(onBackClick: () -> Unit = {},
                 title: String,
                 isSearchBarNeeded: Boolean = false,
                 isMenuIconNeeded: Boolean = false,
                 isTransparent: Boolean = false,
                 modifier: Modifier = Modifier) {

    if(isMenuIconNeeded){
        Box() {
            BaseWidget(content =  {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    // Back button
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = onBackClick, modifier = Modifier) {
                            Icon(imageVector = Icons.Outlined.KeyboardArrowLeft, contentDescription = null, tint = MaterialTheme.colors.secondary)
                        }

                        Text(text = title, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)

                        Icon(imageVector = Icons.Outlined.Menu, contentDescription = "")
                    }
                }
            })
        }
    }
    else if (isSearchBarNeeded) {
        Box() {
            BaseWidget(content = {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    // Back button
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = onBackClick, modifier = Modifier) {
                            Icon(imageVector = Icons.Outlined.KeyboardArrowLeft, contentDescription = null, tint = MaterialTheme.colors.secondary)
                        }

                        SearchTextBox( modifier = Modifier, "Search...", isHomepage = false)
                    }
                }
            })
        }
    }
    else if(isTransparent){

        FooduAppTheme() {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .background(Color.Transparent),

                ) {
                // Back button
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = onBackClick, modifier = Modifier) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    Row(modifier = Modifier.wrapContentSize()) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            imageVector = Icons.Outlined.AddLocation,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
    else {
        FooduAppTheme() {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                // Back button
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackClick, modifier = Modifier) {
                        Icon(imageVector = Icons.Outlined.KeyboardArrowLeft, contentDescription = null, tint = MaterialTheme.colors.secondary)
                    }

                    Text(text = title, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 25.sp, modifier = Modifier.align(CenterVertically))
                }
            }
        }
    }
}