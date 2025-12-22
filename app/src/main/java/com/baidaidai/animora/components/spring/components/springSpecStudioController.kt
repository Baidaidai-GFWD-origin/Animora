package com.baidaidai.animora.components.spring.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.baidaidai.animora.components.spring.springSpecSceenContainer

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun springSpecStudioController(){

    var selected by remember { mutableStateOf(0) }

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(30.dp)
        ) {
            Text("DampingRatio Tab")
            ButtonGroup(
                overflowIndicator = {},
                expandedRatio = 4f,
//                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                toggleableItem(
                    checked = selected == 0,
                    label = "0",
                    onCheckedChange = {
                        selected = 0
                    }
                )
                toggleableItem(
                    checked = selected == 1,
                    label = "1",
                    onCheckedChange = {
                        selected = 1
                    }
                )
            }
            Text("Stiffness Tab")
            Row() { }
        }
    }
}
@Composable
@PreviewLightDark
private fun _springSpecStudioControllerPreview(){
    springSpecStudioController()
}