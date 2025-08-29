package com.example.taller.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Light = lightColorScheme(
    primary = Color(0xFF6A1B9A),
    background = Color.White,
    surface = Color.White
)
private val Dark = darkColorScheme(
    primary = Color(0xFF4A148C),
    background = Color(0xFF121212),
    surface = Color(0xFF121212)
)

@Composable
fun UsersAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) Dark else Light,
        content = content
    )
}
