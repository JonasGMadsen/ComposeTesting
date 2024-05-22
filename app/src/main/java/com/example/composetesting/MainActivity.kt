package com.example.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetesting.viewmodel.BeerViewModel
import com.example.composetesting.ui.theme.ComposeTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestingTheme {
                BeerListScreen()
            }
        }
    }
}

@Composable
fun BeerListScreen() {
    val beerViewModel: BeerViewModel = viewModel()
    val beers by beerViewModel.beersStateFlow.collectAsState()
    val errorMessage by beerViewModel.errorMessageStateFlow.collectAsState()
    val isLoading by beerViewModel.reloadingStateFlow.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = MaterialTheme.colors.error)
            }

            LazyColumn {
                items(beers) { beer ->
                    Text(text = "${beer.name} - ${beer.brewery}")
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { beerViewModel.getBeers() }) {
            Text(text = "Reload Beers")
        }
    }
}