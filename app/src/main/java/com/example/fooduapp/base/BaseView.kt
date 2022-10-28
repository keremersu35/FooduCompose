package com.example.fooduapp.base

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.example.fooduapp.ui.theme.FooduAppTheme
import com.example.fooduapp.view.components.BottomNavigationBar

@Composable
fun ColumnScope.BaseView(
    content: @Composable () -> Unit,
    canScroll : Boolean = true,
    modifier: Modifier? = null,
    viewModel: ViewModel? = null,
    isShowBottomBar : Boolean = false)
{
    if(isShowBottomBar) {
        FooduAppTheme() {
            Scaffold(bottomBar = { BottomNavigationBar() }) {
                if (canScroll) {
                    Column(
                        modifier = modifier!!
                            .padding(it)
                            .background(color = MaterialTheme.colors.background)
                            .verticalScroll(rememberScrollState())
                    ) {
                        content()
                    }
                } else {
                    Column(
                        modifier = modifier!!
                            .padding(it)
                            .fillMaxSize()
                            .background(MaterialTheme.colors.background)
                    ) {
                        content()
                    }
                }
            }
        }
    }else{
        FooduAppTheme() {
            Scaffold() {
                if (canScroll) {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                            .background(color = MaterialTheme.colors.background)
                            .verticalScroll(rememberScrollState())
                    ) {
                        content()
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                            .background(MaterialTheme.colors.background)
                    ) {
                        content()
                    }
                }
            }
        }
    }
}

