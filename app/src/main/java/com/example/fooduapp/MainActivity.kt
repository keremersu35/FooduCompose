package com.example.fooduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fooduapp.model.BottomNavItem
import com.example.fooduapp.ui.theme.FooduAppTheme
import com.example.fooduapp.view.*
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FooduAppTheme {
                val navController = rememberNavController()
                Scaffold() { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screens.SplashScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        composable(route = Screens.SplashScreen.route) {
                            SplashScreen(navController)
                        }

                        composable(route = Screens.OnBoarding.route) {
                            OnBoarding(navController)
                        }

                        composable(route = Screens.HomepageScreen.route) {
                            HomepageScreen(navController)
                        }

                        composable(route = Screens.MealListScreen.route) {
                            MealListScreen(navController = navController)
                        }

                        composable(route = Screens.SearchScreen.route) {
                            SearchScreen(navController = navController)
                        }

                        composable(route = "${Screens.FoodDetailPage.route}/{id}", arguments = listOf(
                            navArgument("id"){
                                type = NavType.IntType
                            }
                        )) {
                            val id = remember {
                                it.arguments?.getInt("id")
                            }
                            FoodDetailScreen(id = id ?: 66186, navController = navController)
                        }
/*
                        composable(BottomNavItem.EWallet.screen_route) {
                            //EWalletScreen()
                        }

                        composable(BottomNavItem.Profile.screen_route) {
                            //ProfileScreen()
                        }*/

                    }
                }
            }
        }
    }
}