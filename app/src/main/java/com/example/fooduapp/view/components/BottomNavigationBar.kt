package com.example.fooduapp.view.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.fooduapp.model.BottomNavItem
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun BottomNavigationBar() {
    FooduAppTheme() {
        val items = listOf(
            BottomNavItem.Home,
            BottomNavItem.Orders,
            BottomNavItem.Message,
            BottomNavItem.EWallet,
            BottomNavItem.Profile
        )
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
            contentColor = Color.White
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title, tint = MaterialTheme.colors.secondary) },
                    label = { Text(text = item.title) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {
                        //TODO: ONCLICK METHODLARI YAZILACAK
                    }
                )
            }
        }
    }
}