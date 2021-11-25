package org.md.squareofftask.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.md.squareofftask.R
import org.md.squareofftask.ui.screen.components.ErrorMessage
import org.md.squareofftask.ui.screen.components.Loader
import org.md.squareofftask.ui.screen.components.TrnList

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val uiState = viewModel.uiState.value
    Surface(modifier = Modifier.fillMaxWidth()) {
        when (uiState) {
            UiState.Error -> {
                ErrorMessage(message = stringResource(R.string.default_error))
            }
            UiState.Loading -> {
                Loader()
            }
            UiState.Success -> {
                TrnList(trns = viewModel.trns)
            }
        }
    }
}

