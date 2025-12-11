package com.baidaidai.animora.components.animation.demo.singel

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun animateColorAsState(
    blueState: Boolean
){
    val color by animateColorAsState(
        targetValue = if (blueState) Color.Red else Color.Gray
    )
    Column {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(MaterialTheme.shapes.small)
                .background(color = color)
            ,
            content = {}
        )
    }
}