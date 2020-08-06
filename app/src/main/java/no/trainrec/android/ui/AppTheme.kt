package no.trainrec.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors

@Composable
fun AppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(colors = darkColors()) {
        content()
    }
}
