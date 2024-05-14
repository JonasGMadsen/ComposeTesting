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
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun StatelessCalculator(
    number1: TextFieldValue,
    number2: TextFieldValue,
    result: String,
    onNumber1Change: (TextFieldValue) -> Unit,
    onNumber2Change: (TextFieldValue) -> Unit,
    onAddClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        TextField(
            value = number1,
            onValueChange = onNumber1Change,
            label = { Text("Enter number 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = number2,
            onValueChange = onNumber2Change,
            label = { Text("Enter number 2") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onAddClick) {
            Text("Add")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(result)
    }
}

// Parent Composable handling the state
@Composable
fun CalculatorApp() {
    var number1 by remember { mutableStateOf(TextFieldValue("")) }
    var number2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    StatelessCalculator(
        number1 = number1,
        number2 = number2,
        result = result,
        onNumber1Change = { number1 = it },
        onNumber2Change = { number2 = it },
        onAddClick = {
            val num1 = number1.text.toInt()
            val num2 = number2.text.toInt()
            result = "Result: ${num1 + num2}"
        }
    )
}

//        TextField(value = "", onValueChange = { }, label = { Text("Enter Text Here") })