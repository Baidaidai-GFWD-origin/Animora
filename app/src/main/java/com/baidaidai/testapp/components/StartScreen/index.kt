package com.baidaidai.testapp.components.StartScreen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baidaidai.testapp.InfoActivity
import com.baidaidai.testapp.components.StartScreen.home.homeScreenComtainer
import com.baidaidai.testapp.components.StartScreen.home.introduceCard
import com.baidaidai.testapp.components.StartScreen.home.onlySpringSpce
import com.baidaidai.testapp.components.StartScreen.list.animationListContainer
import com.baidaidai.testapp.shared.components.NecessaryComponents

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