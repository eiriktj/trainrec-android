package no.trainrec.android.ui;

import no.trainrec.core.domain.ExerciseEntry
import no.trainrec.core.data.TrainingRecord

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Text
import androidx.ui.foundation.TextField
import androidx.ui.foundation.TextFieldValue
import androidx.ui.graphics.Color
import androidx.ui.input.ImeAction
import androidx.ui.input.KeyboardType
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.material.Surface
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MyAppTheme {
        Surface {
            MyContent()
        }
    }
}

@Composable
fun MyContent() {
    val clickedState = state { 0 }
    val titles = listOf("Add", "List")
    val record = TrainingRecord()

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
        //Text(
        //modifier = Modifier.gravity(Alignment.CenterHorizontally),
        //text = "Text tab ${clickedState.value + 1} selected",
        //)
        when(clickedState.value) {
            0 -> AddTab(record)
            1 -> ListTab(record)
        }
    }
}

@Composable
fun AddTab(record: TrainingRecord) {
    val textFieldState = state { TextFieldValue("") }
    Surface(color = Color.DarkGray, modifier = Modifier.padding(16.dp)) {
        TextField(
            value = textFieldState.value,
            keyboardType = KeyboardType.Text,
            modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth(),
            onValueChange = { textFieldState.value = it },
            onImeActionPerformed = { 
                val entry = ExerciseEntry(EntryDate.today().toString(), textFieldState.value.text)
                record.addEntry(entry)
                textFieldState.value = TextFieldValue("")
            }
        )
    }
}

@Composable
fun ListTab(record: TrainingRecord) {
    AdapterList(
        //data = record.listEntries().toList()
        data = record.listEntries()
    ) {
        val exerciseDate = it.getDate()
        val exerciseName = it.getExercise()
        Text("$exerciseDate: $exerciseName")
    }
}

