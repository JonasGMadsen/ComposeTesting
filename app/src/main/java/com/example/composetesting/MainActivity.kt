package com.example.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text("My App") }) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("details") { DetailsScreen(navController) }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        Text(text = "Home Screen")
        Button(onClick = {
            navController.navigate("details")
        }) {
            Text("Go to Details")
        }
    }
}

@Composable
fun DetailsScreen(navController: NavHostController) {
    Column {
        Text(text = "Details Screen")
        Button(onClick = {
            navController.navigate("home")
        }) {
            Text("Back to Home")
        }
    }
}