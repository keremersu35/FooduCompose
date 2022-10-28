package com.example.fooduapp.view

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fooduapp.R
import com.example.fooduapp.base.BaseView
import com.example.fooduapp.data.remote.dto.Category
import com.example.fooduapp.data.remote.dto.CategoryRoot
import com.example.fooduapp.view.components.*
import com.example.fooduapp.view.viewmodel.HomepageViewModel

@Composable
fun HomepageScreen(
    navController: NavController
) {
    val viewModel: HomepageViewModel = hiltViewModel()

        Column() {
            BaseView(
                modifier = Modifier.height(1200.dp),
                isShowBottomBar = true,
                canScroll = true,
                viewModel = viewModel,
                content = {

                    val stateRandom = viewModel.stateRandom.value
                    val stateCategory = viewModel.stateCategory.value
                    val stateMealList = viewModel.stateMealList.value

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(top = 5.dp)
                    ) {
                        HomepageAppBar()
                    }

                    SearchTextBox(
                        Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(15.dp)), "What are you craving?",
                            isHomepage = true, navController = navController
                    )

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                            .fillMaxWidth()
                            .height(30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Random Meal",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.secondary
                        )
                    }

                    stateRandom.meal?.let { meal ->
                        RandomMeal(
                            text = meal?.name ?: "",
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(170.dp)
                                .clip(
                                    RoundedCornerShape(15.dp)
                                ),
                            imageUrl = meal?.imageUrl ?: "",
                            isLoading = false,
                            navController = navController,
                            id = meal?.id ?: 0
                        )
                    }

                    if (stateRandom.error.isNotBlank()) {
                        Text(
                            text = stateRandom.error,
                            color = MaterialTheme.colors.error,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .align(CenterHorizontally)
                        )
                    }
                    if (stateRandom.isLoading) {
                        RandomMeal(
                            text = "", color = MaterialTheme.colors.primary, modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .height(170.dp)
                                .clip(
                                    RoundedCornerShape(15.dp)
                                ), imageUrl = "",
                            isLoading = true,
                            navController = navController,
                            id = 0
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .height(40.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Meals",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.secondary
                        )
                        Text(
                            text = "See All",
                            fontSize = 14.sp,
                            color = MaterialTheme.colors.primary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.clickable { navController.navigate(Screens.MealListScreen.route) }
                        )
                    }

                    SmallCategoryList(modifier = Modifier.height(40.dp))

                    stateMealList.meal?.let { mealList ->
                        MealList(
                            modifier = Modifier
                                .height(400.dp)
                                .padding(10.dp),
                            mealList = mealList,
                            isHomepage = true,
                            navController = navController
                        )
                    }
                })
        }
    }
/*
        if(stateCategory.error.isNotBlank()){
            Text(
                text = stateRandom.error,
                color= MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
        if(stateCategory.isLoading) {
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier
                    .align(Alignment.Center)
                )
            }
        }
} */