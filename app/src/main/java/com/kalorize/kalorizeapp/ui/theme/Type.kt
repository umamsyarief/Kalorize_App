package com.example.kalorize_project.ui.theme

// Set of Material typography styles to start with
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kalorize_project.R

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.fontResource

// Menentukan font resources
val RobotoRegular = FontFamily(
    Font(R.font.roboto_regular)
)

val RobotoMedium = FontFamily(
    Font(R.font.roboto_medium, FontWeight.Medium)
)

val RobotoBold = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold)
)