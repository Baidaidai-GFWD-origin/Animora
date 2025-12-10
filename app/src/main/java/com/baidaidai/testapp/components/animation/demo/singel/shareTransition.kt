package com.baidaidai.testapp.components.animation.demo.singel

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun shareTransition(blueState: Boolean){
    SharedTransitionLayout {
        AnimatedContent(blueState){ blueState ->
            if (blueState){
                Row(
                    modifier = Modifier
                        .sharedBounds(
                            sharedContentState = rememberSharedContentState("Border"),
                            animatedVisibilityScope = this@AnimatedContent
                        )
                        .fillMaxWidth()
                        .border(1.dp, color = Color.Black)
                    ,
                ){
                    Text(
                        text = "Title",
                        modifier = Modifier
                            .sharedElement(
                                sharedContentState = rememberSharedContentState("Title"),
                                animatedVisibilityScope = this@AnimatedContent
                            )
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut l",
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .sharedElement(
                                sharedContentState = rememberSharedContentState("Content"),
                                animatedVisibilityScope = this@AnimatedContent
                            )
                    )
                }
            }else{
                Column(
                    modifier = Modifier
                        .sharedBounds(
                            sharedContentState = rememberSharedContentState("Border"),
                            animatedVisibilityScope = this@AnimatedContent
                        )
                        .size(100.dp)
                        .border(1.dp, color = Color.Black)
                    ,
                ){
                    Text(
                        text = "Title",
                        modifier = Modifier
                            .sharedElement(
                                sharedContentState = rememberSharedContentState("Title"),
                                animatedVisibilityScope = this@AnimatedContent
                            )
                    )
                    Text(
                        text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut l",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .sharedElement(
                                sharedContentState = rememberSharedContentState("Content"),
                                animatedVisibilityScope = this@AnimatedContent
                            )
                    )
                }
            }
        }
    }
}