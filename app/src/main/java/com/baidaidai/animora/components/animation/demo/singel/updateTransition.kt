package com.baidaidai.animora.components.animation.demo.singel

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun _updateTransition(blueState: Boolean){
    val genLock = updateTransition(blueState)
    val contentColor by genLock.animateColor { blueState->
        if (blueState){
            Color.Red
        }else{
            Color.Gray
        }
    }
    val contentSize by genLock.animateDp { blueState ->
        if (blueState){
            300.dp
        }else{
            100.dp
        }
    }
    Column {
        Box(
            modifier = Modifier
                .size(height = 100.dp, width = contentSize)
                .background(color = contentColor),
            content = {}
        )
    }
}