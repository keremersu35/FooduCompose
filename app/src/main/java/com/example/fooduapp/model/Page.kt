package com.example.fooduapp.model

import com.example.fooduapp.R

class Page(
    val image: Int,
    val title: Int,
    val desc: Int
) {
    companion object{
        fun getData(): List<Page>{
            return listOf(
                Page(R.drawable.onboarding1, R.string.onboarding_title1, R.string.onboarding_desc),
                Page(R.drawable.onboarding2, R.string.onboarding_title2, R.string.onboarding_desc),
                Page(R.drawable.onboarding3, R.string.onboarding_title3, R.string.onboarding_desc)
            )
        }
    }
}
