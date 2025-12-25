package com.baidaidai.animora.components.spring

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.baidaidai.animora.components.spring.animationStudio.animationStudio
import com.baidaidai.animora.components.spring.model.springSpecStudioViewModel
import com.baidaidai.animora.components.animation.detail.NecessaryComponents
import com.baidaidai.animora.components.spring.components.springSpecControllerHost
import com.baidaidai.animora.components.spring.components.springSpecStudioController
import com.baidaidai.animora.shared.viewModel.blueStateViewModel
import dev.jeziellago.compose.markdowntext.MarkdownText

val LocalSpringSpecStudioViewModel = compositionLocalOf<springSpecStudioViewModel>{ error("No springSpecStudioViewModel provided") }

@Composable
fun springSpecSceenContainer(
    navController: NavController
){

    val blueStateViewModel = viewModel<blueStateViewModel>()
    val springSpecStudioViewModel = viewModel<springSpecStudioViewModel>()

    val blueState by blueStateViewModel.blueState.collectAsState()

    val assetsManager = LocalContext.current.assets
    var inputStream = assetsManager.open("markdown/springSpec.md")
    var markdownContent = inputStream.bufferedReader().use { it.readText() }

    Scaffold(
        topBar = {
            NecessaryComponents.animationDetailsTopAppBar(
                content = "SpringSpce Studio"
            ) {
                navController.popBackStack()
                blueStateViewModel.changeBlueState(false)
            }
        },
        floatingActionButton = {
            NecessaryComponents.animationDetailsFloatActionButton {
                blueStateViewModel.changeBlueState(!blueState)
            }
        }
    ){ contentPaddingValues->
        Column(
            modifier = Modifier
                .padding(contentPaddingValues)
                .scrollable(
                    state = rememberScrollableState { 1f },
                    orientation = Orientation.Vertical
                )
                .padding(horizontal = 30.dp)
        ){
            Card(
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.error,
                    disabledContentColor = MaterialTheme.colorScheme.onError
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .padding(30.dp)
                ) {
                    animationStudio(
                        blueState = blueState,
                        springSpecStudioViewModel = springSpecStudioViewModel
                    )
                }
            }
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp,
                        start = 5.dp,
                        end = 5.dp
                    )
            )
            CompositionLocalProvider(
                LocalSpringSpecStudioViewModel provides springSpecStudioViewModel
            ) {
                springSpecControllerHost()
            }
            HorizontalDivider(
                thickness = 0.1.dp,
                modifier = Modifier
                    .padding(
                        bottom = 10.dp,
                        start = 5.dp,
                        end = 5.dp
                    )
            )
            MarkdownText(
                markdown = markdownContent,
                modifier = Modifier
                    .verticalScroll(
                        state = rememberScrollState()
                    )
                    .padding(
                        bottom = 100.dp
                    )
            )
        }
    }
}
