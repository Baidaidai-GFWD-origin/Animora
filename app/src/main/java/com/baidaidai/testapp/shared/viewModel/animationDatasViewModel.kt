package com.baidaidai.testapp.shared.viewModel

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.baidaidai.testapp.components.list.model.animationList
import com.baidaidai.testapp.shared.dataClass.AnimationDatas
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.baidaidai.testapp.R
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveable
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
