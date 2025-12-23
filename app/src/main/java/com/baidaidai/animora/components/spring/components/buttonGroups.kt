package com.baidaidai.animora.components.spring.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun toggleButton(
    list:List<*>,
    index: Int,
    content: String,
    checked: Boolean,
    rowScope: RowScope,
    onCheckedChange:()-> Unit
){
    with(rowScope){
            ToggleButton(
                checked = checked,
                onCheckedChange = {
                    onCheckedChange()
                },
                shapes = when(index){
                    0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
                    list.lastIndex -> ButtonGroupDefaults.connectedTrailingButtonShapes()
                    else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                },
                modifier = Modifier
                    .height(40.dp)
                    .weight(
                        weight = if (checked) 1.3f else 1f
                    )
            ) {
                Text(
                    text = content,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )
    }
}