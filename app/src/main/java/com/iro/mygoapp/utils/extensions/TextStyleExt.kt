package com.iro.mygoapp.utils.extensions

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.TextUnit
import com.iro.mygoapp.utils.Size
import com.iro.mygoapp.utils.Style


// Primary text style method
@Composable
fun primaryTextStyle(
    color: Color = MaterialTheme.colorScheme.onPrimary,
    fontSize: TextUnit = Size.textPrimarySizeGlobal,
    fontWeight: FontWeight? = Style.fontWeightPrimaryGlobal,
    fontStyle: FontStyle? = FontStyle.Normal,
   // fontFamily: FontFamily? = FontFamily(),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    background: Color = Color.Unspecified,
    textDecoration: TextDecoration? = TextDecoration.None,
    textAlign: TextAlign? = TextAlign.Start,
    textDirection: TextDirection? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
): TextStyle {
    return TextStyle(
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        //fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        background = background,
        textDecoration = textDecoration,
        textAlign = textAlign,
        textDirection = textDirection,
        lineHeight = lineHeight,
    )
}

// Bold text style method

@Composable
fun boldTextStyle(
    color: Color = MaterialTheme.colorScheme.onPrimary,
    fontSize: TextUnit = Size.textBoldSizeGlobal,
    fontWeight: FontWeight? = Style.fontWeightBoldGlobal,
    fontStyle: FontStyle? = FontStyle.Normal,
   // fontFamily: FontFamily? = FontFamily(),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    background: Color = Color.Unspecified,
    textDecoration: TextDecoration? = TextDecoration.None,
    textAlign: TextAlign? = TextAlign.Start,
    textDirection: TextDirection? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
): TextStyle {
    return TextStyle(
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        //fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        background = background,
        textDecoration = textDecoration,
        textAlign = textAlign,
        textDirection = textDirection,
        lineHeight = lineHeight,
    )
}

/* Secondary text style method */
@Composable
fun secondaryTextStyle(
    color: Color = MaterialTheme.colorScheme.onSurface,
    fontSize: TextUnit = Size.textSecondarySizeGlobal,
    fontWeight: FontWeight? = Style.fontWeightSecondaryGlobal,
    fontStyle: FontStyle? = FontStyle.Normal,
   // fontFamily: FontFamily? = FontFamily(),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    background: Color = Color.Unspecified,
    textDecoration: TextDecoration? = TextDecoration.None,
    textAlign: TextAlign? = TextAlign.Start,
    textDirection: TextDirection? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
): TextStyle {
    return TextStyle(
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
       // fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        background = background,
        textDecoration = textDecoration,
        textAlign = textAlign,
        textDirection = textDirection,
        lineHeight = lineHeight,
    )
}