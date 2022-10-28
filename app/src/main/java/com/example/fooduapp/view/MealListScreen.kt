package com.example.fooduapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fooduapp.base.BaseView
import com.example.fooduapp.view.components.CustomAppBar
import com.example.fooduapp.view.components.MealList
import com.example.fooduapp.view.viewmodel.MealListViewModel

@Composable
fun MealListScreen(
    viewModel: MealListViewModel = hiltViewModel(),
    navController: NavController
) {
    val stateMealList = viewModel.stateMealList.value

    stateMealList.meal?.let { mealList ->
        Column() {
            BaseView(isShowBottomBar = false, canScroll = false, modifier = Modifier,content = {

                Column() {
                    CustomAppBar(title = "Meal List", modifier = Modifier.height(50.dp), onBackClick = { navController.popBackStack() })
                    MealList(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(10.dp),
                        mealList = mealList,
                        isHomepage = false,
                        navController = navController
                    )
                }
            })
        }
    }
    if(stateMealList.error.isNotBlank()){
        Text(
            text = stateMealList.error,
            color= MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
    if(stateMealList.isLoading) {
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier
                .align(Alignment.Center)
            )
        }
    }
}