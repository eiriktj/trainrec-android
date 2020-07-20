package no.trainrec.android.ui;

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val appFilesDir = this.getFilesDir().getAbsolutePath()
        val app = App(appFilesDir)

        setContent {
            app.Content()
        }

    }
}
