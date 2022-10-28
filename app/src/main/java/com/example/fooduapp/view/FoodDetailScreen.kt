package com.example.fooduapp.view

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.SyncLock
import androidx.compose.material.icons.outlined.Timelapse
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.fooduapp.base.BaseView
import com.example.fooduapp.view.components.CustomAppBar
import com.example.fooduapp.view.components.FoodInfoCard
import com.example.fooduapp.view.viewmodel.FoodDetailViewModel

@Composable
fun FoodDetailScreen(
    navController: NavController,
    id: Int,
    viewModel: FoodDetailViewModel = hiltViewModel<FoodDetailViewModel>()
) {
    Column {
        val state = viewModel.state.value
        state.meal?.let {meal ->

            BaseView(isShowBottomBar = false, canScroll = false, content = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = meal.image,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(
                                Alignment.Center
                            )
                    )
                    CustomAppBar(title = "", isTransparent = true, onBackClick = {
                        navController.popBackStack()
                    })
                }

                Text(
                    text = meal.title,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FoodInfoCard(
                        icon = Icons.Outlined.People,
                        title = meal.servings.toString(),
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    FoodInfoCard(
                        icon = Icons.Outlined.SyncLock,
                        title = "${meal.readyInMinutes} min",
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    FoodInfoCard(
                        icon = Icons.Outlined.Favorite,
                        title = "${meal.healthScore} pt",
                        modifier = Modifier.weight(1f)
                    )
                }

                Text(
                    text = meal.instructions,
                    color = MaterialTheme.colors.secondary, modifier = Modifier
                        .padding(15.dp)
                        .wrapContentHeight()
                        .fillMaxWidth(), textAlign = TextAlign.Center
                )
            })
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
    }
}