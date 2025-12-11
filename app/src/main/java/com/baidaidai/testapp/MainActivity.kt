package com.baidaidai.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.baidaidai.testapp.ui.theme.TestAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baidaidai.testapp.components.animation.detail.animationDetailContainer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baidaidai.testapp.shared.viewModel.animationDatasViewModel
import androidx.compose.ui.platform.LocalContext
import com.baidaidai.testapp.components.StartScreen.startScreenContainer
import com.baidaidai.testapp.shared.viewModel.blueStateViewModel

val LocalAnimationViewModel = compositionLocalOf<animationDatasViewModel> {
    error("No animationDatasViewModel provided")
}

class MainActivity : ComponentActivity() {
    @OptIn(
        ExperimentalMaterial3Api::class,
        ExperimentalMaterial3ExpressiveApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                val animationDetailsViewModel = viewModel<animationDatasViewModel>()
                CompositionLocalProvider(
                    LocalAnimationViewModel provides animationDetailsViewModel
                ) {
                    TestApp()
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
fun TestApp(
) {

    val homeViewNavController = rememberNavController()
    val totalNavigationController = rememberNavController()
    val blueStateViewModel = viewModel<blueStateViewModel>()
    val context = LocalContext.current

    NavHost(
        navController = totalNavigationController,
        startDestination = "Start"
    ) {
        composable(
            route = "Start"
        ){
            startScreenContainer(
                context = context,
                homeViewNavController = homeViewNavController,
                totalNavigationController = totalNavigationController
            )
        }
        composable(
            route = "Detail"
        ){
            animationDetailContainer(
                blueStateViewModel = blueStateViewModel,
                navController = totalNavigationController
            )
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@PreviewLightDark
@Composable
fun TextBoxPreview() {
    TestAppTheme {
        TestApp()
    }
}