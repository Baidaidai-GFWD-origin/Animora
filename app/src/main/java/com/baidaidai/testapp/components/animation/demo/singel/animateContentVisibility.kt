package com.baidaidai.testapp.components.animation.demo.singel

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun animateContentVisibility(blueState: Boolean) {
    AnimatedContent(blueState) { blueState ->
        if (!blueState){
            Column {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(color = Color.Gray)
                        .animateEnterExit(
                            enter = fadeIn(),
                            exit = fadeOut()
                        ),
                    content = {}
                )
            }
        }
    }
}