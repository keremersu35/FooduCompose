package com.example.fooduapp.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooduapp.ui.theme.FooduAppTheme
import com.example.fooduapp.ui.theme.Grayish
import com.example.fooduapp.view.Screens

@Composable
fun SearchTextBox( modifier: Modifier, text: String, isHomepage: Boolean, navController: NavController? = null) {
    FooduAppTheme() {

        var text by remember { mutableStateOf("") }

        if (isHomepage) {
            Row(modifier = modifier
                .fillMaxWidth()
                .background(Grayish)
                .padding(15.dp)
                .clip(
                    RoundedCornerShape(15.dp)
                )
                .clickable { navController?.navigate(Screens.SearchScreen.route) }) {

                Icon(imageVector = Icons.Default.Search, contentDescription = "", modifier = Modifier.align(
                    Alignment.CenterVertically), tint = Color.Black)

                Text(text = "  What are you craving? ", color = Color.Gray)

            }
        }else{
            Row(modifier = modifier
                .padding(15.dp)
                .fillMaxWidth()
                .height(60.dp)
                .clip(
                    RoundedCornerShape(15.dp)
                )
                .background(Grayish)
                .padding(5.dp)
                ){
                Icon(imageVector = Icons.Default.Search, contentDescription = "", modifier = Modifier.align(
                    Alignment.CenterVertically), tint = Color.Black)
                TextField(value = "", placeholder = { Text(text = text)}, onValueChange = { text += it },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                        cursorColor = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                    ), modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxSize()
                        .onFocusChanged { }
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint : String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember{
        mutableStateOf("")
    }

    var isHintDisplayed by remember{
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier){
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),

            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && text.isEmpty()
                },
        )

        if(isHintDisplayed){
            Text(text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp))
        }
    }
}