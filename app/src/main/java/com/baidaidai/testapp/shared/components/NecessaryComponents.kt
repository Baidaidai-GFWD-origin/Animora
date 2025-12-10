package com.baidaidai.testapp.shared.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Animation
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.baidaidai.testapp.R
import com.baidaidai.testapp.components.home.model.BarItemInside
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

final object NecessaryComponents {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun homeTopAppBar(){
        TopAppBar(
            title = {
                Text("Jetpack Animation Overview")
            },
            actions = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.info_24px),
                        contentDescription = ""
                    )
                }
            }
        )
    }

    @Composable
    fun homeButtomBar(
        controller: NavHostController
    ){
        val coroutineScope = rememberCoroutineScope()

        NavigationBar {

            val NavigationRenderingList = listOf<BarItemInside>(
                BarItemInside(0, Icons.Outlined.Home, "Home"),
                BarItemInside(1, Icons.AutoMirrored.Outlined.List, "List")
            )

            var selected by rememberSaveable { mutableIntStateOf(0) }

            NavigationRenderingList.forEach { item ->
                NavigationBarItem(
                    selected = selected == item.number,
                    onClick = {
                        selected = item.number
                        coroutineScope.launch {
                            controller.navigate(item.contentDescription)
                        }
                    },
                    icon = {
                        Icon(item.pattern, item.contentDescription)
                    },
                    label = {
                        Text(item.contentDescription)
                    }
                )
            }
        }
    }

    @OptIn(
        ExperimentalMaterial3Api::class,
        ExperimentalSharedTransitionApi::class
    )
    @Composable
    fun animationDetailsTopAppBar(
        animationId: Int,
        content: String,
        onClick: () -> Unit

    ){
        TopAppBar(
            title = {
                Text(text = content)
            },
            navigationIcon = {
                IconButton(
                    onClick = onClick
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "Back"
                    )
                }
            }
        )
    }

    @Composable
    fun animationDetailsFloatActionButton(
        onClick:()-> Unit
    ){
        ExtendedFloatingActionButton(
            onClick = onClick,
            icon = { Icon(Icons.Outlined.Animation, "Click To Start Animation") },
            text = { Text(text = "Start Animation") },
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.Companion
                .padding(bottom = 50.dp)
        )
    }
}