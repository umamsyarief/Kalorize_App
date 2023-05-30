package com.uistack.onboarding

import androidx.compose.ui.graphics.Color
import com.example.kalorize_project.ui.theme.BlackFul

data class OnBoardingData(
    val image: Int, val title: String,
    val desc: String,
    val backgroundColor:Color,
    val mainColor:Color = BlackFul
)