package com.baidaidai.animora.components.animation.detail

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.baidaidai.animora.LocalAnimationViewModel
import com.baidaidai.animora.shared.viewModel.blueStateViewModel

@Composable
fun animationDetailContainer(
    blueStateViewModel: blueStateViewModel,
    navController: NavController
){



    val animationDatasViewModel = LocalAnimationViewModel.current
    val blueStateViewModel = blueStateViewModel

    val blueState by blueStateViewModel.blueState.collectAsState()
    val animationDatas by animationDatasViewModel.selectedAnimation.collectAsState()

    Scaffold(
        topBar = {
            NecessaryComponents.animationDetailsTopAppBar(
                content = animationDatas.name
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
                    animationDatas.animationFiles(blueStateViewModel.blueState.collectAsState().value)
                }
            }
            HorizontalDivider(
                thickness = 3.dp,
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp,
                        start = 5.dp,
                        end = 5.dp
                    )
            )
            Text(
                text = stringResource(animationDatas.details)
            )
        }
    }
}


//@Composable
//@PreviewLightDark
//fun animationDetailContainerPreview(){
//    TestAppTheme {
//        animationDetailContainer()
//    }
//}