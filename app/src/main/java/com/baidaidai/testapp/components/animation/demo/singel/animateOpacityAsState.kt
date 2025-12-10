package com.baidaidai.testapp.components.animation.demo.singel

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun animateOpacityAsState(
    blueState: Boolean
){
    val alpha by animateFloatAsState(
        targetValue = if (blueState) 0f else 1f
    )
    Column {
        Box(
            modifier = Modifier
                .size(100.dp)
                .alpha(alpha)
                .background(color = Color.Gray),
            content = {}
        )
    }
}