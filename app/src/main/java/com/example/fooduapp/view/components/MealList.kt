package com.example.fooduapp.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooduapp.R
import com.example.fooduapp.data.remote.dto.MealListDto
import com.example.fooduapp.domain.model.MealListModel
import com.example.fooduapp.domain.model.SearchResultModel
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun MealList(modifier: Modifier, mealList: MealListModel? = null, isHomepage: Boolean, searchMealList: SearchResultModel? = null, navController: NavController) {
    FooduAppTheme() {
        if (isHomepage) {
            LazyColumn(modifier = modifier
                .fillMaxWidth(), userScrollEnabled = false) {
                items((mealList!!.results)){ meal->
                    Box(modifier = Modifier.padding(horizontal = 3.dp)) {
                        MealListItem(meal.title, "Good Meal, nice", imageUrl = meal.image, navController = navController, id = meal.id)
                    }
                }
            }
        } else if(!isHomepage && mealList != null){
            LazyColumn(modifier = modifier
                .fillMaxWidth()) {
                items((mealList!!.results)){ meal->
                    Box(modifier = Modifier.padding(horizontal = 3.dp)) {
                        MealListItem(meal.title, "Good Meal, nice", imageUrl = meal.image, navController = navController, id = meal.id)
                    }
                }
            }
        } else{
            if(searchMealList != null)
                LazyColumn(modifier = modifier
                    .fillMaxWidth()) {
                    items((searchMealList!!.results)){ meal->
                        Box(modifier = Modifier.padding(horizontal = 3.dp)) {
                            MealListItem(meal.title, "Good Meal, nice", imageUrl = meal.image, navController = navController, id = meal.id)
                        }
                    }
                }
        }
    }
}