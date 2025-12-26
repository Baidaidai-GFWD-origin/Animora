package com.baidaidai.animora.components.animation.demo.singel

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.baidaidai.animora.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun sharedElement(blueState: Boolean){
    SharedTransitionLayout {
        AnimatedContent(
            targetState = blueState,
        ){ blueState ->
            if (blueState){
                Row(
                    modifier = Modifier
                        .sharedElement(
                            sharedContentState = rememberSharedContentState("image"),
                            animatedVisibilityScope = this@AnimatedContent
                        )
                ){
                    Image(
                        painter = painterResource(R.drawable.demo_tree),
                        contentDescription = "A image",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(shape = CircleShape)
                    )
                }
            }else{
                Row(
                    modifier = Modifier
                        .sharedElement(
                            sharedContentState = rememberSharedContentState("image"),
                            animatedVisibilityScope = this@AnimatedContent
                        )
                ){
                    Image(
                        painter = painterResource(R.drawable.demo_tree),
                        contentDescription = "A image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(shape = CircleShape)
                    )
                }
            }
        }
    }
}