package com.baidaidai.testapp.components.StartScreen.list

import androidx.annotation.StringRes
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QuestionMark
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.baidaidai.testapp.LocalAnimationViewModel
import com.baidaidai.testapp.components.StartScreen.list.components.animationListItem
import com.baidaidai.testapp.components.StartScreen.list.components.modalBottomSheet
import com.baidaidai.testapp.components.StartScreen.list.model.animationList
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
    var bottomSheetState by rememberSaveable { mutableStateOf(false) }
    val modalBottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    val blurValue by animateDpAsState(
        targetValue = if (bottomSheetState) 10.dp else 0.dp
    )

    @StringRes
    var bottomSheetContent: Int by rememberSaveable { mutableIntStateOf(0) }

    if (bottomSheetState){
        modalBottomSheet(
            onDismissRequest = {
                modalBottomSheetState.hide()
                bottomSheetState = !bottomSheetState
            },
            modalBottomSheetState = modalBottomSheetState,
            bottomSheetContent = bottomSheetContent
        )
    }
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(contentPaddingValues)
            .padding(start = 20.dp, end = 20.dp)
            .blur(blurValue)
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
                    animationListItem(
                        animationList = animationList,
                        listOnClick = {
                            animationDatasViewModel.changeSelectedAnimation(
                                animationDatas = animationList
                            )
                            navController.navigate("Detail")
                        },
                        questionOnClick = {
                            bottomSheetContent = animationList.shortInfo
                            coroutineScope.launch {
                                bottomSheetState = !bottomSheetState
                                delay(500)
                                modalBottomSheetState.show()
                            }
                        }
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