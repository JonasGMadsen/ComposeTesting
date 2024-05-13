package com.example.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator()
        }
    }
}

@Composable
fun Calculator() {
    var number1 by remember { mutableStateOf(TextFieldValue("")) }
    var number2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        TextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Enter number 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Enter number 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val num1 = number1.text.toInt()
            val num2 = number2.text.toInt()
            result = "Result: ${num1 + num2}"
        }) {
            Text("Add")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(result)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Calculator()
}