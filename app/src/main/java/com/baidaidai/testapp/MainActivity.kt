package com.baidaidai.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.baidaidai.testapp.ui.theme.TestAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.baidaidai.testapp.components.animation.detail.animationDetailContainer
import com.baidaidai.testapp.shared.components.NecessaryComponents
import com.baidaidai.testapp.components.home.introduceCard
import com.baidaidai.testapp.components.home.onlySpringSpce
import com.baidaidai.testapp.components.list.animationListContainer
import com.baidaidai.testapp.shared.dataClass.AnimationDatas
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.baidaidai.testapp.shared.viewModel.animationDatasViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import com.baidaidai.testapp.shared.viewModel.blueStateViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                val animationDetailsViewModel = viewModel<animationDatasViewModel>()
                TestViewModel(
                    viewModel = animationDetailsViewModel
                )
            }
        }
    }
}

@ExperimentalMaterial3ExpressiveApi
@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class,
    ExperimentalSharedTransitionApi::class
)
@Composable
fun TestViewModel(
    viewModel: animationDatasViewModel
) {

    val navController = rememberNavController()
    val blueStateViewModel = viewModel<blueStateViewModel>()
    val blueState by blueStateViewModel.blueState.collectAsState()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var topAppBarContent = viewModel.selectedAnimation.collectAsState().value.name
    var animationId = viewModel.selectedAnimation.collectAsState().value.id
    Scaffold(
        topBar = {
            when(currentRoute){
                "Details" -> {
                    NecessaryComponents.animationDetailsTopAppBar(
                        animationId = animationId,
                        content = topAppBarContent,
                        onClick = {
                            navController.popBackStack()
                            blueStateViewModel.changeBlueState(false)
                        }
                    )
                }
                else -> {
                    NecessaryComponents.homeTopAppBar()
                }
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute != "Details",
                exit = shrinkVertically(
                    shrinkTowards = Alignment.Bottom
                ),
                enter = expandVertically(
                    expandFrom = Alignment.Top
                )
            ) {
                NecessaryComponents.homeButtomBar(
                    controller = navController
                )
            }
        },
        floatingActionButton = {
            if (currentRoute == "Details"){
                NecessaryComponents.animationDetailsFloatActionButton {
                    blueStateViewModel.changeBlueState(!blueState)
                }
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = "Home"
        ) {
            composable(
                route = "Home"
            ){
                Column(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                        .padding(contentPadding)
                        .padding(start = 20.dp, end = 20.dp)
                ) {
                    introduceCard()
                    onlySpringSpce()
                }
            }
            navigation(
                startDestination = "List",
                route = "ListRoute"
            ) {
                composable (
                    route = "List"
                ) {
                    animationListContainer(
                        viewModel = viewModel,
                        contentPaddingValues = contentPadding,
                        navController = navController,
                    )
                }
                composable(
                    route = "Details"
                ){
                    animationDetailContainer(
                        viewModel = viewModel,
                        contentPaddingValues = contentPadding,
                        blueStateViewModel = blueStateViewModel
                    )
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@PreviewLightDark
@Composable
fun TextBoxPreview() {
    val animationDatasViewModel = viewModel<animationDatasViewModel>()

    TestAppTheme {
        TestViewModel(
            viewModel = animationDatasViewModel
        )
    }
}