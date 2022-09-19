package com.example.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basics.ui.theme.BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsTheme {
                myApp()
                }
            }
        }
    }

@Composable
fun myApp(names: List <String> = listOf("Strong" , "Loved")) {
    Column()
        {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }
@Composable
fun Greeting(name: String) {
    val expanded = remember{ mutableStateOf(false)}
    val extraPadding = if (expanded.value) 30.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 20.dp),
        shape = RoundedCornerShape(20.dp)
    ) {

        Row (modifier=Modifier.padding(20.dp))
        {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            )
            {
                Text(text = "You are,")
                Text(text = name)
            }

            OutlinedButton(
                onClick = { expanded.value = !expanded.value },
                shape = RoundedCornerShape(10.dp)
            )
            {
                Text( if (expanded.value) "Show more" else "Show less")

            }
        }
    }
}