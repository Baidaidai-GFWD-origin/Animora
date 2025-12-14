package com.baidaidai.animora.components.animation.demo

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object infiniteTransition {

    @Composable
    fun animateColor(){
        val infiniteTransition = rememberInfiniteTransition(label = "infiniteTransition Demo")
        val bgColor:Color by infiniteTransition.animateColor(
            initialValue = Color.Gray,
            targetValue = Color.Red,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing = EaseInOut
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        Column {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = bgColor),
                content = {}
            )
        }
    }

    @Composable
    fun animateFloat(){
        val infiniteTransition = rememberInfiniteTransition(label = "infiniteTransition Demo")
        val size by infiniteTransition.animateFloat(
            initialValue = 100f,
            targetValue = 300f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = EaseInOut
                ),
                repeatMode = RepeatMode.Reverse
            )

        )
        Column {
            Box(
                modifier = Modifier
                    .size(height = 100.dp, width = size.dp)
                    .background(color = Color.Gray),
                content = {}
            )
        }

    }

}