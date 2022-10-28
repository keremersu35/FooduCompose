package com.example.fooduapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavItem(var title:String, var icon: ImageVector, var screen_route:String){

    object Home : BottomNavItem("Home", Icons.Default.Home,"home")
    object Orders: BottomNavItem("Orders", Icons.Default.BorderBottom,"orders")
    object Message: BottomNavItem("Message", Icons.Default.Message,"message")
    object EWallet: BottomNavItem("E - Wallet", Icons.Default.Wallet,"e_wallet")
    object Profile: BottomNavItem("Profile", Icons.Default.Person,"profile")
}

