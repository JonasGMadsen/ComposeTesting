package com.example.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetesting.ui.theme.ComposeTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestingTheme {
                // Call your BeerListScreen here
                BeerListScreen()
            }
        }
    }
}

@Composable
fun BeerListScreen() {
    val beerViewModel: BeerViewModel = viewModel()
    val beers by beerViewModel.beersLiveData.observeAsState(initial = emptyList())
    val errorMessage by beerViewModel.errorMessageLiveData.observeAsState("")
    val isLoading by beerViewModel.reloadingLiveData.observeAsState(false)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
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
