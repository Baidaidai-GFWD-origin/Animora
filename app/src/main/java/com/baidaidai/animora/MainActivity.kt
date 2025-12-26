package com.baidaidai.animora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.baidaidai.animora.ui.theme.TestAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baidaidai.animora.components.animation.detail.animationDetailContainer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baidaidai.animora.shared.viewModel.animationDatasViewModel
import androidx.compose.ui.platform.LocalContext
import com.baidaidai.animora.components.spring.springSpecSceenContainer
import com.baidaidai.animora.components.StartScreen.startScreenContainer
import com.baidaidai.animora.shared.viewModel.blueStateViewModel

val LocalAnimationViewModel = compositionLocalOf<animationDatasViewModel> {
    error("No animationDatasViewModel provided")
}

@OptIn(ExperimentalSharedTransitionApi::class)
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope>{
    error("No SharedTransitionScope provided")
}

@OptIn(ExperimentalSharedTransitionApi::class)
val LocalAnimatedContentScope = compositionLocalOf<AnimatedContentScope>{
    error("No AnimatedContentScope provided")
}

class MainActivity : ComponentActivity() {
    @OptIn(
        ExperimentalMaterial3Api::class,
        ExperimentalMaterial3ExpressiveApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
                val animationDetailsViewModel = viewModel<animationDatasViewModel>()
                CompositionLocalProvider(
                    LocalAnimationViewModel provides animationDetailsViewModel
                ) {
                    AnimoraApp()
                }
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
fun AnimoraApp(
) {

    val homeViewNavController = rememberNavController()
    val totalNavigationController = rememberNavController()
    val blueStateViewModel = viewModel<blueStateViewModel>()
    val context = LocalContext.current

    SharedTransitionLayout {
        NavHost(
            navController = totalNavigationController,
            startDestination = "Start"
        ) {
            composable(
                route = "Start"
            ){
                CompositionLocalProvider(
                    LocalSharedTransitionScope provides this@SharedTransitionLayout,
                    LocalAnimatedContentScope provides this@composable
                ) {
                    startScreenContainer(
                        context = context,
                        homeViewNavController = homeViewNavController,
                        totalNavigationController = totalNavigationController,
                    )
                }
            }
            composable(
                route = "Detail"
            ){
                CompositionLocalProvider(
                    LocalSharedTransitionScope provides this@SharedTransitionLayout,
                    LocalAnimatedContentScope provides this@composable
                ) {
                    animationDetailContainer(
                        blueStateViewModel = blueStateViewModel,
                        navController = totalNavigationController,
                    )
                }
            }
            composable(
                route = "springStudio"
            ){
                springSpecSceenContainer(
                    navController = totalNavigationController
                )
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@PreviewLightDark
@Composable
fun TextBoxPreview() {
    TestAppTheme {
        AnimoraApp()
    }
}