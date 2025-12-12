package com.baidaidai.animora.components.StartScreen.list.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.baidaidai.animora.shared.dataClass.AnimationDatas
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun animationListItem(
    animationList: AnimationDatas,
    listOnClick:suspend()-> Unit,
    questionOnClick:suspend()-> Unit

){
    val coroutineScope = rememberCoroutineScope()
    ListItem(
        headlineContent = {
            Text(
                text = animationList.name,
            )
        },
        trailingContent = {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        questionOnClick()
                    }
                }
            ) {
                Icon(Icons.Outlined.QuestionMark, contentDescription = "Question")
            }
        },
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(
                onClick = {
                    coroutineScope.launch {
                        listOnClick()
                    }
                }
            )
    )
}