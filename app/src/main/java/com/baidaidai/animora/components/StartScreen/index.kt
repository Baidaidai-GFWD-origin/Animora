package com.baidaidai.animora.components.StartScreen

import android.content.Context
import android.content.Intent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baidaidai.animora.InfoActivity
import com.baidaidai.animora.components.StartScreen.home.homeScreenComtainer
import com.baidaidai.animora.components.StartScreen.list.animationListContainer
import com.baidaidai.animora.components.StartScreen.model.homeScreenBlurViewModel
import com.baidaidai.animora.shared.components.NecessaryComponents

@Composable
fun startScreenContainer(
    context: Context,
    homeViewNavController: NavHostController,
    totalNavigationController: NavHostController
){
    val intent = Intent(context,InfoActivity::class.java)

    val homeScreenBlurViewModel = viewModel<homeScreenBlurViewModel>()
    val blurStatus by homeScreenBlurViewModel.blurStatus.collectAsState()
    val blurValue by animateDpAsState(
        targetValue = if (blurStatus) 10.dp else 0.dp
    )

    Scaffold(
        topBar = {
            NecessaryComponents.homeTopAppBar {
                context.startActivity(intent)
            }
        },
        bottomBar = {
            NecessaryComponents.homeButtomBar(
                controller = homeViewNavController
            )
        },
        modifier = Modifier
            .blur(blurValue)
    ) { contentPadding ->
        NavHost(
            navController = homeViewNavController,
            startDestination = "Home",
        ) {
            composable(
                route = "Home"
            ){
                homeScreenComtainer(
                    contentPadding = contentPadding,
                    onlySpringSpecOnClick = {
                        totalNavigationController.navigate("springStudio")
                    }
                )
            }
            composable (
                route = "List"
            ) {
                animationListContainer(
                    contentPaddingValues = contentPadding,
                    navController = totalNavigationController,
                    viewModel = homeScreenBlurViewModel
                )
            }
        }

    }
}