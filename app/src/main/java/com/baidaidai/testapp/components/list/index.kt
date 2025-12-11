package com.baidaidai.testapp.components.list

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.baidaidai.testapp.LocalAnimationViewModel
import com.baidaidai.testapp.components.list.model.animationList
import com.baidaidai.testapp.shared.viewModel.animationDatasViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun animationListContainer(
    contentPaddingValues: PaddingValues,
    navController: NavController,
){

    val animationDatasViewModel = LocalAnimationViewModel.current
    var BottomSheetState by rememberSaveable { mutableStateOf(false) }
    val modalBottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    @StringRes
    var BottomSheetContent: Int by rememberSaveable { mutableIntStateOf(0) }

    if (BottomSheetState){
        ModalBottomSheet(
            onDismissRequest = {
                coroutineScope.launch {
                    modalBottomSheetState.hide()
                    BottomSheetState = false
                }
            },
            sheetState = modalBottomSheetState
        ) {
            Column(
                modifier = Modifier
                    .defaultMinSize(minHeight = 200.dp)
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(BottomSheetContent)
                )
            }

        }
    }

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(contentPaddingValues)
            .padding(start = 20.dp, end = 20.dp)
    ) {

        LazyColumn {

            items(
                items = animationList,
                key = { animationList ->
                    animationList.id
                }
            ) { animationList->
                Column(
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                ) {
                    ListItem(
                        headlineContent = {
                            Text(
                                text = animationList.name,
                            )
                        },
                        trailingContent = {
                            IconButton(
                                onClick = {
                                    BottomSheetContent = animationList.shortInfo
                                    coroutineScope.launch {
                                        BottomSheetState = !BottomSheetState
                                        delay(500)
                                        modalBottomSheetState.show()
                                    }

                                }
                            ) {
                                Icon(Icons.Outlined.QuestionMark, contentDescription = "Question")
                            }
                        },
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.medium)
                            .clickable(onClick = {
                                animationDatasViewModel.changeSelectedAnimation(
                                    animationDatas = animationList
                                )
                                navController.navigate("Details")
                            })
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }

}