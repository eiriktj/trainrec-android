package no.trainrec.android.ui

import java.io.File

import android.content.Context

import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumnItems
import androidx.compose.foundation.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TextField
import androidx.compose.ui.unit.dp

import no.trainrec.android.adapter.Presenter
import no.trainrec.storage.FileIO

class App(activityContext: Context) {
    private val context: Context
    private val presenter: Presenter

    init {
        context = activityContext

        val io = setupFileIO()
        presenter = Presenter(io)
    }

    fun setupFileIO(): FileIO {
        val appFilesDir = context.getFilesDir()
        val appData = File(appFilesDir, "data.csv")
        appData.createNewFile() // Does nothing if file already exists
        val io = FileIO(appData)
        return io
    }

    @Composable
    fun Content() {
        AppTheme {
            Surface {
                val clickedState = state { 0 }
                val titles = listOf("Add", "List")

                Column {
                    TabRow(
                        items = titles,
                        selectedIndex = clickedState.value,
                    ) { index, text ->
                        Tab(
                            text = { Text(text) },
                            selected = clickedState.value == index,
                            onSelected = { clickedState.value = index }
                        )
                    }
                    when(clickedState.value) {
                        0 -> AddEntryTab(presenter, context)
                        1 -> ListEntriesTab(presenter)
                    }
                }
            }
        }
    }
}


@Composable
fun AddEntryTab(presenter: Presenter, context: Context) {
    val textFieldState =  state { TextFieldValue("") }
    Surface(color = Color.DarkGray, modifier = Modifier.padding(16.dp)) {
        TextField(
            value = textFieldState.value,
            label = { Text("") },
            keyboardType = KeyboardType.Text,
            onValueChange = { textFieldState.value = it },
            onImeActionPerformed = { action, softwareController ->
                presenter.addEntry(textFieldState.value.text)
                textFieldState.value = TextFieldValue("")
            }
        )
    }
}

@Composable
fun ListEntriesTab(presenter: Presenter) {
    Button(
        onClick = { presenter.save() },
        backgroundColor = Color.DarkGray
    ) {
        Text("Save entries")
    }
    LazyColumnItems(
        items = presenter.listEntries()
    ) {
        Text(it)
    }
}

