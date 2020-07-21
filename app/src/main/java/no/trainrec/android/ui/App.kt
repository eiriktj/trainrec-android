package no.trainrec.android.ui

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.Text
import androidx.ui.foundation.TextField
import androidx.ui.graphics.Color
import androidx.ui.input.KeyboardType
import androidx.ui.input.TextFieldValue
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Surface
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.unit.dp

class App(appFilesDir: String) {
    private val presenter = Presenter(appFilesDir)

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
                        0 -> AddTab(presenter)
                        1 -> ListTab(presenter)
                    }
                }
            }
        }
    }
}


@Composable
fun AddTab(presenter: Presenter) {
    val textFieldState = state { TextFieldValue("") }
    Surface(color = Color.DarkGray, modifier = Modifier.padding(16.dp)) {
        TextField(
            value = textFieldState.value,
            keyboardType = KeyboardType.Text,
            modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth(),
            onValueChange = { textFieldState.value = it },
            onImeActionPerformed = { 
                presenter.addEntry(textFieldState.value.text)
                textFieldState.value = TextFieldValue("")
            }
        )
    }
}

@Composable
fun ListTab(presenter: Presenter) {
    LazyColumnItems(
        items = presenter.listEntries()
    ) {
        Text(it)
    }
}

