package com.example.fooduapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fooduapp.base.BaseView
import com.example.fooduapp.view.components.MealList
import com.example.fooduapp.view.components.SearchBar
import com.example.fooduapp.view.viewmodel.SearchScreenViewModel

@Composable
fun SearchScreen(
    viewModel : SearchScreenViewModel = hiltViewModel(),
    navController: NavController
) {

    Column() {
        val state = viewModel.stateSearchList.value
        BaseView(isShowBottomBar = false, canScroll = false, content = {
            SearchBar(hint = "Search for meals", modifier = Modifier.padding(10.dp).fillMaxWidth().height(50.dp).padding(5.dp), onSearch = {
                viewModel.getSearchList(it)})

            state.meal?.let{ meal ->
                MealList(
                    modifier = Modifier
                        .padding(10.dp),
                    searchMealList = meal,
                    isHomepage = false,
                    navController = navController
                )
            }

            if(state.error.isNotBlank()){
                Text(
                    text = state.error,
                    color= MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )
            }
            if(state.isLoading) {
                Box(modifier = Modifier.fillMaxSize()){
                    CircularProgressIndicator(modifier = Modifier
                        .align(Alignment.Center)
                    )
                }
            }
        })
    }
}