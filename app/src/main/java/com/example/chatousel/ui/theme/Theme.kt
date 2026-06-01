package com.example.chatousel.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.compose.foundation.shape.RoundedCornerShape

@Immutable
data class EqualColors(
    val chatBackground: Color,
    val appBar: Color,
    val incomingBubble: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val dividerText: Color,
    val actionGreen: Color,
)

private val LocalEqualColors = staticCompositionLocalOf {
    EqualColors(
        chatBackground = EqualLightBackground,
        appBar = EqualLightAppBar,
        incomingBubble = EqualLightBubble,
        primaryText = EqualLightText,
        secondaryText = EqualLightTextMuted,
        dividerText = EqualLightTextMuted,
        actionGreen = EqualGreen,
    )
}

val MaterialTheme.equalColors: EqualColors
    @Composable get() = LocalEqualColors.current

private val DarkColorScheme = darkColorScheme(
    primary = EqualGreenBright,
    onPrimary = Color.Black,
    secondary = EqualGreen,
    onSecondary = Color.Black,
    background = EqualDarkBackground,
    onBackground = EqualDarkText,
    surface = EqualDarkBubble,
    onSurface = EqualDarkText,
    surfaceVariant = EqualDarkCardRaised,
    onSurfaceVariant = EqualDarkTextMuted,
    outline = EqualDarkOutline,
)

private val LightColorScheme = lightColorScheme(
    primary = EqualGreen,
    onPrimary = Color.White,
    secondary = EqualGreen,
    onSecondary = Color.White,
    background = EqualLightBackground,
    onBackground = EqualLightText,
    surface = EqualLightBubble,
    onSurface = EqualLightText,
    surfaceVariant = EqualLightCardTint,
    onSurfaceVariant = EqualLightTextMuted,
    outline = EqualLightOutline,
)

private val DarkEqualColors = EqualColors(
    chatBackground = EqualDarkBackground,
    appBar = EqualDarkAppBar,
    incomingBubble = EqualDarkBubble,
    primaryText = EqualDarkText,
    secondaryText = EqualDarkTextMuted,
    dividerText = EqualDarkTextMuted,
    actionGreen = EqualGreenBright,
)

private val LightEqualColors = EqualColors(
    chatBackground = EqualLightBackground,
    appBar = EqualLightAppBar,
    incomingBubble = EqualLightBubble,
    primaryText = EqualLightText,
    secondaryText = EqualLightTextMuted,
    dividerText = EqualLightTextMuted,
    actionGreen = EqualGreen,
)

private val EqualShapes = Shapes(
    extraSmall = RoundedCornerShape(6.dp),
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(28.dp),
)

@Composable
fun ChatouselTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val equalColors = if (darkTheme) DarkEqualColors else LightEqualColors

    CompositionLocalProvider(LocalEqualColors provides equalColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = EqualShapes,
            content = content,
        )
    }
}
