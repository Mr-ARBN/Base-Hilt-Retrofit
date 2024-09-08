package com.example.basehiltretrofit

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.basehiltretrofit.domain.model.remote.TestResponse
import com.example.basehiltretrofit.domain.utility.UiState

@Composable
fun TestScreenOne(viewModel: ViewModel = hiltViewModel(), name: String) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        viewModel.getDataRemote()
    }
    TestScreenOne(
        state = state,
        name = name,
        retry = { viewModel.getDataRemote() }
    )
}

@Composable
fun TestScreenOne(
    state: UiState<TestResponse>,
    name: String,
    retry: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValue ->
        when (state) {
            UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    LinearProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            is UiState.Success -> {
                ProfileScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue)
                        .padding(paddingValue),
                    input = state.data.name + " $name",
                )
            }

            is UiState.Error -> {
                Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
                    Button(
                        modifier = Modifier
                            .align(Alignment.Center),
                        content = { Text(text = "Retry") },
                        onClick = { retry() }
                    )
                    Toast.makeText(context, state.errorMessage, Toast.LENGTH_LONG).show()
                }
            }

            else -> Unit
        }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier, input: String) {
    Box(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = input
        )
    }
}