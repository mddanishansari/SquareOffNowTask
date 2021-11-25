package org.md.squareofftask.ui.screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.md.squareofftask.di.AppModule
import org.md.squareofftask.domain.model.Trn

class MainViewModel : ViewModel() {

    private val mainRepository = AppModule.mainRepository

    val trns = mutableStateListOf<Trn>()

    private val _uiState = mutableStateOf<UiState>(UiState.Loading)
    val uiState = _uiState as State<UiState>

    init {
        getTrns()
    }

    private fun getTrns() {
        _uiState.value = UiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val trns = mainRepository.getTrns()
                withContext(Dispatchers.Main) {
                    this@MainViewModel.trns.addAll(trns)
                    _uiState.value = UiState.Success
                }
            } catch (e: Exception) {
                Log.e("ERROR", "getTrns: ", e)
                withContext(Dispatchers.Main) {
                    _uiState.value = UiState.Error
                }
            }
        }
    }
}