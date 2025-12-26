package com.baidaidai.animora.components.animation.detail

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Animation
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

final object NecessaryComponents {
    @OptIn(
        ExperimentalMaterial3Api::class,
        ExperimentalSharedTransitionApi::class
    )
    @Composable
    fun animationDetailsTopAppBar(
        content: String,
        sharedTransitionScope: SharedTransitionScope,
        animatedContentScope: AnimatedContentScope,
        onClick: () -> Unit,
    ){
        with(sharedTransitionScope){
            TopAppBar(
                title = {
                    Text(
                        text = content,
                        modifier = Modifier
                            .sharedBounds(
                                sharedContentState = rememberSharedContentState("AnimationTitle-${content}"),
                                animatedVisibilityScope = animatedContentScope
                            )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onClick
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIosNew,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    }

    @Composable
    fun animationDetailsFloatActionButton(
        onClick:()-> Unit
    ){
        ExtendedFloatingActionButton(
            onClick = onClick,
            icon = { Icon(Icons.Outlined.Animation, "Click To Start Animation") },
            text = { Text(text = "Start Animation") },
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier
                .offset(
                    y = (-10).dp,
                    x = (-15).dp
                )
        )
    }
}