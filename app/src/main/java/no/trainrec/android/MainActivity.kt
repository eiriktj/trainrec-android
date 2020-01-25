package no.trainrec.android;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import androidx.ui.core.Text
import androidx.ui.material.surface.Surface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface {
                    Text(text = "Hello World!")
                }
            }
        }
    }
}
