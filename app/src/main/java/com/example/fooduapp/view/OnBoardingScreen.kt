package com.example.fooduapp.view

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooduapp.base.BaseView
import com.example.fooduapp.model.BottomNavItem
import com.example.fooduapp.model.Page
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnBoarding(navController: NavController) {
    val items = Page.getData()
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()

    Column() {
        BaseView(canScroll = false, content = {
            TopSection(
                onBackClick = {
                    if (pageState.currentPage + 1 > 1) scope.launch {
                        pageState.scrollToPage(pageState.currentPage - 1)
                    }
                },
                onSkipClick = {
                    if (pageState.currentPage + 1 < items.size) scope.launch {
                        pageState.scrollToPage(items.size - 1)
                    }
                }
            )

            HorizontalPager(
                count = items.size,
                state = pageState,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth()
            ) { page ->
                OnBoardingItem(items = items[page])
            }
            BottomSection( size = items.size,navController = navController, index = pageState.currentPage, onButtonClick = {
                if (pageState.currentPage + 1 < items.size) scope.launch {
                    pageState.scrollToPage(pageState.currentPage + 1)
                }
            })
        })
    }
}

@ExperimentalPagerApi
@Composable
fun TopSection(onBackClick: () -> Unit = {}, onSkipClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        // Back button
        IconButton(onClick = onBackClick, modifier = Modifier.align(Alignment.CenterStart)) {
            Icon(imageVector = Icons.Outlined.KeyboardArrowLeft, contentDescription = null)
        }

        // Skip Button
        TextButton(
            onClick = onSkipClick,
            modifier = Modifier.align(Alignment.CenterEnd),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "Skip", color = MaterialTheme.colors.background)
        }
    }
}

@Composable
fun BottomSection(size: Int, index: Int, onButtonClick: () -> Unit = {},  navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        Indicators(size, index)

        FloatingActionButton(
            backgroundColor = MaterialTheme.colors.primary,
            onClick = { navController.navigate(Screens.HomepageScreen.route) },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
        ) {
            Icon(
                Icons.Outlined.KeyboardArrowRight,
                tint = Color.White,
                contentDescription = "Localized description")
        }
    }
}

@Composable
fun BoxScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.CenterStart)
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) MaterialTheme.colors.primary else Color(0XFFF8E2E7)
            )
    ) {

    }
}

@Composable
fun OnBoardingItem(items: Page) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box (modifier = Modifier.weight(2f)) {
            Image(
                painter = painterResource(id = items.image),
                contentDescription = "Image1",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(450.dp)
            )
        }

        Spacer(modifier = Modifier.weight(0.01f))

        Box(modifier = Modifier.weight(0.3f)) {
            Text(
                text = stringResource(id = items.title),
                style = MaterialTheme.typography.body1,
                fontSize = 32.sp,
                color = MaterialTheme.colors.primaryVariant,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                letterSpacing = 1.sp,
            )
        }
        Spacer(modifier = Modifier.weight(0.01f))

        Box(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(id = items.desc),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp),
                letterSpacing = 1.sp,
            )
        }
    }
}