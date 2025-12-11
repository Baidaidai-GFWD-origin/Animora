package com.baidaidai.testapp.shared.viewModel

import androidx.lifecycle.ViewModel
import com.baidaidai.testapp.components.StartScreen.list.model.animationList
import com.baidaidai.testapp.shared.dataClass.AnimationDatas
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class animationDatasViewModel: ViewModel() {
    private val _selectedAnimation = MutableStateFlow(animationList[0])
    val selectedAnimation = _selectedAnimation.asStateFlow()


    fun changeSelectedAnimation(animationDatas: AnimationDatas) {
        _selectedAnimation.update {
            animationDatas
        }
    }
}
