package com.example.fooduapp.view

sealed class Screens(val route: String){
    object SplashScreen: Screens("splash_screen")
    object OnBoarding: Screens("onboarding_screen")
    object FoodDetailPage: Screens("food_detail_screen")
    object HomepageScreen: Screens("homepage_screen")
    object MealListScreen: Screens("meal_screen")
    object SearchScreen: Screens("search_screen")
}
