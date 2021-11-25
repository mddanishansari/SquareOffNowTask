package org.md.squareofftask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.md.squareofftask.ui.screen.MainScreen
import org.md.squareofftask.ui.screen.MainViewModel
import org.md.squareofftask.ui.theme.SquareOffTaskTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SquareOffTaskTheme {
                // A surface container using the 'background' color from the theme
                MainScreen(viewModel = mainViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SquareOffTaskTheme {
        Greeting("Android")
    }
}