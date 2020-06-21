package no.trainrec.android;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.material.Tab
import androidx.ui.material.TabRow

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
    val clickedState: MutableState<Int> = state { 0 }
    val titles = listOf("TAB 1", "TAB 2")

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
        Text(
        modifier = Modifier.gravity(Alignment.CenterHorizontally),
        text = "Text tab ${clickedState.value + 1} selected",
        style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text (text = "Hello $name!")
}
