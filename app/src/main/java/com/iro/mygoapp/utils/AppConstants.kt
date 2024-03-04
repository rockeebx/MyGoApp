package com.iro.mygoapp.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp



object Style {
    var fontWeightBoldGlobal: FontWeight = FontWeight.Bold
    var fontWeightPrimaryGlobal: FontWeight = FontWeight.Normal
    var fontWeightSecondaryGlobal: FontWeight = FontWeight.Normal

}

object TextColor {
    val textPrimaryColor = Color(0xFF2E3033)
    val textSecondaryColor = Color(0xFF757575)
    val textPrimaryLightColor = Color(0xFF212121)
    val textPrimaryDarkColor = Color(0xFFFFFFFF)
    val textSecondaryLightColor = Color(0xFF5A5C5E)
    val textSecondaryDarkColor = Color(0x8AFFFFFF)

}

object Size {
    var textBoldSizeGlobal = 16.0.sp
    var textPrimarySizeGlobal = 16.0.sp
    var textSecondarySizeGlobal = 14.0.sp
}