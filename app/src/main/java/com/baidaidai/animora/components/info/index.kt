package com.baidaidai.animora.components.info

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.baidaidai.animora.components.info.infoScreen.NecessaryComponents

@Composable
fun infoScreen(){
    val activity = LocalContext.current as Activity
    Scaffold(
        topBar = {
            NecessaryComponents.infoScreenTopAppBar {
                activity.finish()
            }
        }
    ){ contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 20.dp)
        ){
            infoAreaContainer()
            Spacer(
                modifier = Modifier.size(height = 10.dp, width = 1.dp)
            )
            authorAreaContainer()
        }
    }
}

@PreviewLightDark
@Composable
private fun infoScreenPreview(){
    infoScreen()
}