package com.android.qrcodegenerator.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = ButtonBlue,
    secondary = SkyBlue,
    background = White,
    surface = CardColor
)

@Composable
fun QRCodeGeneratorTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
