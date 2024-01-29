package com.example.litenote.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.litenote.R

val AvenirLT = FontFamily(
    Font(
        resId = R.font.avenir_lt_book,
        weight = FontWeight.Normal
    ),

    Font(
        resId = R.font.avenir_lt_medium,
        weight = FontWeight.Medium
    ),

    Font(
        resId = R.font.avenir_lt_black,
        weight = FontWeight.Black
    )
)

val CoreSans = FontFamily(
    Font(
        resId = R.font.core_sans_regular,
        weight = FontWeight.Normal
    ),

    Font(
        resId = R.font.core_sans_bold,
        weight = FontWeight.Bold
    )
)

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = CoreSans,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),

    titleSmall = TextStyle(
        fontFamily = CoreSans,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = AvenirLT,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = CoreSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = CoreSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
)