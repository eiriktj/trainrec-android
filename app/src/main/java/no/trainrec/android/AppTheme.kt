package no.trainrec.android;

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.ColorPalette
import androidx.ui.material.MaterialTheme

private val darkThemeColors = ColorPalette(
    primary = Color(0xFFEA6D7E),
    primaryVariant = Color(0xFFDD0D3E),
    onPrimary = Color.Black,
    secondary = Color(0xFF121212),
    onSecondary = Color.White,
    surface = Color(0xFF121212),
    background = Color(0xFF121212),
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun AppTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = darkThemeColors) {
        children()
    }
}
