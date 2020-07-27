package no.trainrec.android.ui

import java.io.File

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent

import no.trainrec.storage.FileIO

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val appFilesDir = this.getFilesDir()
            val appData = File(appFilesDir, "data.csv")
            appData.createNewFile() // Does nothing if file already exists
            val io = FileIO(appData)
            val app = App(io)
            app.Content()
        }

    }
}
