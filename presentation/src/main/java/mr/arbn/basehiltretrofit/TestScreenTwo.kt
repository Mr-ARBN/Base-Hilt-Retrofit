package mr.arbn.basehiltretrofit

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
import mr.arbn.basehiltretrofit.domain.model.remote.TestResponse
import mr.arbn.basehiltretrofit.domain.utility.UiState

@Composable
fun TestScreenTwo(viewModel: ViewModel = hiltViewModel(), name: String) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        viewModel.getDataRemote()
    }
    TestScreenTwo(
        state = state,
        name = name,
        retry = { viewModel.getDataRemote() }
    )
}

@Composable
fun TestScreenTwo(
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
                FriendsScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                        .padding(paddingValue),
                    input = "$name: ${state.data.data.cpuModel}"
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
fun FriendsScreen(modifier: Modifier, input: String) {
    Box(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = input,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}