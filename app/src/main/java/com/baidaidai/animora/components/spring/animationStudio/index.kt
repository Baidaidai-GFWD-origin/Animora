package com.baidaidai.animora.components.spring.animationStudio

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.baidaidai.animora.components.spring.model.springSpecParameterData
import com.baidaidai.animora.components.spring.model.springSpecStudioViewModel

fun animationProvider(
    enableSpring: Boolean,
    springSpecValue: springSpecParameterData
):AnimationSpec<Float> {
    when(enableSpring){
        true -> {
            return spring(
                dampingRatio = springSpecValue.dampingRatio,
                stiffness = springSpecValue.stiffness,
                visibilityThreshold = null
            )
        }
        else -> {
            return tween()
        }
    }
}

@Composable
fun animationStudio(
    blueState: Boolean,
    springSpecStudioViewModel: springSpecStudioViewModel
){
    var widthValue = remember { Animatable(100f) }
    val springSpecValue by springSpecStudioViewModel.springSpecValue.collectAsState()
    val enableSpring by springSpecStudioViewModel.enableSpring.collectAsState()

    LaunchedEffect(blueState) {
        if (blueState){
            widthValue.animateTo(
                targetValue = 300f,
                animationSpec = animationProvider(
                    enableSpring = enableSpring,
                    springSpecValue = springSpecValue
                )
            )
        }else{
            widthValue.animateTo(
                targetValue = 100f,
                animationSpec = animationProvider(
                    enableSpring = enableSpring,
                    springSpecValue = springSpecValue
                )
            )
        }
    }
    Column {
        Box(
            modifier = Modifier
                .size(height = 100.dp,width = widthValue.value.dp)
                .background(color = Color.Gray),
            content = {}
        )
    }
}