package com.example.fooduapp.base

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import com.example.fooduapp.ui.theme.FooduAppTheme

@Composable
fun ColumnScope.BaseWidget() {
    FooduAppTheme() {

    }
}

@Composable
fun RowScope.BaseWidget() {
    FooduAppTheme() {

    }
}

@Composable
fun BoxScope.BaseWidget(content: @Composable () -> Unit,) {
    FooduAppTheme() {
        content
    }
}