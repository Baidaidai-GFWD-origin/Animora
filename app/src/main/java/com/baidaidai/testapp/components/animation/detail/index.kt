package com.baidaidai.testapp.components.animation.detail

import android.R
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baidaidai.testapp.ui.theme.TestAppTheme
import com.baidaidai.testapp.components.list.model.animationList
import com.baidaidai.testapp.shared.dataClass.AnimationDatas
import com.baidaidai.testapp.shared.viewModel.animationDatasViewModel
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.baidaidai.testapp.shared.viewModel.blueStateViewModel

@Composable
fun animationDetailContainer(
    viewModel: animationDatasViewModel,
    contentPaddingValues: PaddingValues,
    blueStateViewModel: blueStateViewModel
){



    val animationDatasViewModel = viewModel
    val animationDatas by animationDatasViewModel.selectedAnimation.collectAsState()

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


//@Composable
//@PreviewLightDark
//fun animationDetailContainerPreview(){
//    TestAppTheme {
//        animationDetailContainer()
//    }
//}