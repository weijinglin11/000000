package com.example.example3

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.example3.ui.theme.Example3Theme
import androidx.compose.material3.Button as B

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Example3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var textName by remember { mutableStateOf("") }
    var textKey by remember { mutableStateOf("") }
    var readValue by remember { mutableStateOf("") }
    Column {
        Column(
            modifier = modifier.padding(50.dp, 10.dp, 50.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                label = {
                    Text(
                        text = "键名"
                    )
                },
                value = textName,
                onValueChange = {
                    textName = it
                }
            )
            TextField(
                label = {
                    Text(
                        text = "键值"
                    )
                },
                value = textKey,
                onValueChange = {
                    textKey = it
                }
            )
            Button(onClick = { readValue = textKey }) {
                Text("保存数据并读取")
            }
        }
        Text(text = "读取的数据：$readValue")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreentingPreview(){
    Example3Theme{
        Greeting()
    }
}


