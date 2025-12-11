package com.baidaidai.testapp.components.info.infoScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

object NecessaryComponents {
    @OptIn(
        ExperimentalMaterial3Api::class,
        ExperimentalMaterial3ExpressiveApi::class
    )
    @Composable
    fun infoScreenTopAppBar(
        onClick: ()-> Unit
    ){
        TopAppBar(
            navigationIcon = {
                IconButton(
                    onClick = onClick
                ) {
                    Icon(
                        Icons.Outlined.ArrowBackIosNew,
                        contentDescription = "Back"
                    )
                }
            },
            title = {
                Text("About")
            }
        )
    }

}