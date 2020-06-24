package no.trainrec.android;

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
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
            0 -> AddTab()
            1 -> ListTab()
        }
    }
}

@Composable
fun AddTab() {
    val textFieldState = state { TextFieldValue("") }
    val textOutput = state { "" }
    Surface(color = Color.DarkGray, modifier = Modifier.padding(16.dp)) {
        TextField(
            value = textFieldState.value,
            keyboardType = KeyboardType.Text,
            modifier = Modifier.padding(16.dp) + Modifier.fillMaxWidth(),
            onValueChange = { textFieldState.value = it },
            onImeActionPerformed = { 
                textOutput.value = textFieldState.value.text
            }
        )
    }
    Text(textOutput.value)
}

@Composable
fun ListTab() {
    Text( text = "ListTab")
}

