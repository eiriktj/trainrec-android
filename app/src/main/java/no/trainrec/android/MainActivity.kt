package no.trainrec.android;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.core.TextField
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.material.surface.Surface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Column {
        TextField(value = "")
        Button(text = "")
        Button(text = "")
    }
}
