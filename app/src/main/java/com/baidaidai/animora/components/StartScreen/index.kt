package com.baidaidai.animora.components.StartScreen

import android.content.Context
import android.content.Intent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baidaidai.animora.InfoActivity
import com.baidaidai.animora.components.StartScreen.home.homeScreenComtainer
import com.baidaidai.animora.components.StartScreen.list.animationListContainer
import com.baidaidai.animora.shared.components.NecessaryComponents

@Composable
fun startScreenContainer(
    context: Context,
    homeViewNavController: NavHostController,
    totalNavigationController: NavHostController
){
    val intent = Intent(context,InfoActivity::class.java)

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
        }
    ) { contentPadding ->

        NavHost(
            navController = homeViewNavController,
            startDestination = "Home",
        ) {
            composable(
                route = "Home"
            ){
                homeScreenComtainer(
                    contentPadding = contentPadding
                )
            }
            composable (
                route = "List"
            ) {
                animationListContainer(
                    contentPaddingValues = contentPadding,
                    navController = totalNavigationController,
                )
            }
        }

    }
}