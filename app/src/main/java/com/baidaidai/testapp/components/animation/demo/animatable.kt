package com.baidaidai.testapp.components.animation.demo

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.keyframesWithSpline
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

object animatable {

    @Composable
    fun AnimateTo(blueState: MutableState<Boolean>){
        var alphaValue = remember { Animatable(1f) }
        LaunchedEffect(blueState.value) {
            if (blueState.value){
                alphaValue.animateTo(0.5f)
                delay(1000)
                alphaValue.animateTo(0f)
            }else{
                alphaValue.animateTo(1f)
            }
        }
        Column {
            Text("Animatable.animateTo(alpha)异步Async")
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .alpha(alphaValue.value)
                    .background(color = Color.Gray),
                content = {}
            )
        }
    }

    @Composable
    fun withMediumSpringSpec(blueState: MutableState<Boolean>){
        var widthValue = remember { Animatable(100f) }
        LaunchedEffect(blueState.value) {
            if (blueState.value){
                widthValue.animateTo(
                    targetValue = 50f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                delay(1000)
                widthValue.animateTo(
                    targetValue = 300f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
            }else{
                widthValue.animateTo(
                    targetValue = 100f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
            }
        }
        Column {
            Text("Animatable.animateTo(width) With SpringSpec")
            Box(
                modifier = Modifier
                    .size(height = 100.dp,width = widthValue.value.dp)
                    .background(color = Color.Gray),
                content = {}
            )
        }
    }

    @Composable
    fun withDIYBezier(blueState: MutableState<Boolean>){
        var widthValue = remember { Animatable(100f) }
        LaunchedEffect(blueState.value) {
            // 移除 <Float> 泛型
            val animSpec = tween<Float>(
                durationMillis = 1000,
                easing = CubicBezierEasing(1.00f, 0.00f, 0.00f, 1.00f)
            )
            if (blueState.value){
                widthValue.animateTo(
                    targetValue = 50f,
                    animationSpec = animSpec
                )
                delay(1000)
                widthValue.animateTo(
                    targetValue = 300f,
                    animationSpec = animSpec
                )
            }else{
                widthValue.animateTo(
                    targetValue = 100f,
                    animationSpec = animSpec
                )
            }
        }
        Column {
            Text("Animatable.animateTo(width) With DIY Bezier")
            Box(
                modifier = Modifier
                    .size(height = 100.dp,width = widthValue.value.dp)
                    .background(color = Color.Gray),
                content = {}
            )
        }
    }

    @Composable
    fun withKeyframesSpline(blueState: MutableState<Boolean>) {
        val widthValue = remember { Animatable(100f) }
        LaunchedEffect(blueState.value) {
            val animSpec = keyframesWithSpline<Float> {
                durationMillis = 3000 // 总动画时长
                50f at 500 using CubicBezierEasing(1.00f, 0.00f, 0.00f, 1.00f)
                150f at 2000 using CubicBezierEasing(1.00f, 0.00f, 0.00f, 1.00f)
                300f at 3000 using CubicBezierEasing(1.00f, 0.00f, 0.00f, 1.00f)
            }

            if (blueState.value) {
                widthValue.animateTo(
                    targetValue = 300f, // 最终目标值
                    animationSpec = animSpec
                )
            } else {
                widthValue.animateTo(
                    targetValue = 100f,
                    animationSpec = snap()
                )
            }
        }
        Column {
            Text("Animatable.animateTo(width) With KeyframesSpline & Bezier")
            Box(
                modifier = Modifier
                    .size(height = 100.dp, width = widthValue.value.dp)
                    .background(color = Color.Gray),
                content = {}
            )
        }
    }

    @Composable
    fun withInfinityRepeatable(blueState: MutableState<Boolean>) {
        val widthValue = remember { Animatable(100f) }

        LaunchedEffect(blueState.value) {
            if (blueState.value) {
                widthValue.animateTo(
                    targetValue = 300f,
                    animationSpec = infiniteRepeatable(
                        animation = keyframes {
                            durationMillis = 3000
                            50f at 500 using CubicBezierEasing(1.00f, 0.00f, 0.00f, 1.00f)
                            150f at 2000 using CubicBezierEasing(1.00f, 0.00f, 0.00f, 1.00f)
                            300f at 3000 using CubicBezierEasing(1.00f, 0.00f, 0.00f, 1.00f)
                        },
                        repeatMode = RepeatMode.Reverse
                    )
                )
            } else {
                widthValue.animateTo(
                    targetValue = 100f,
                    animationSpec = snap()
                )
            }
        }
        Column {
            Text("Animatable with InfinityRepeatable")
            Box(
                modifier = Modifier
                    .size(height = 100.dp, width = widthValue.value.dp)
                    .background(color = Color.Gray),
                content = {}
            )
        }
    }

    @Composable
    fun withSnap(blueState: MutableState<Boolean>) {
        val widthValue = remember { Animatable(100f) }

        LaunchedEffect(blueState.value) {
            if (blueState.value) {
                widthValue.animateTo(
                    targetValue = 300f,
                    animationSpec = snap()
                )
            } else {
                widthValue.animateTo(
                    targetValue = 100f,
                    animationSpec = snap()
                )
            }
        }
        Column {
            Text("Animatable with SnapSpec")
            Box(
                modifier = Modifier
                    .size(height = 100.dp, width = widthValue.value.dp)
                    .background(color = Color.Gray),
                content = {}
            )
        }
    }


}

