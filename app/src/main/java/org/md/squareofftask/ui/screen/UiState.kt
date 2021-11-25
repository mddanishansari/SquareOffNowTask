package org.md.squareofftask.ui.screen

sealed class UiState {
    object Loading : UiState()
    object Success : UiState()
    object Error : UiState()
}
