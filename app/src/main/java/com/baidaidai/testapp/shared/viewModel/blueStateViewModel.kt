package com.baidaidai.testapp.shared.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class blueStateViewModel: ViewModel() {
    private val _blueState = MutableStateFlow(false)
    val blueState = _blueState.asStateFlow()

    fun changeBlueState(state: Boolean){
        _blueState.value = state
    }
}