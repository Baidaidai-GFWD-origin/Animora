package com.baidaidai.animora.components.StartScreen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun homeScreenComtainer(
    contentPadding: PaddingValues,
    onlySpringSpecOnClick: ()-> Unit
){
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(contentPadding)
            .padding(start = 20.dp, end = 20.dp)
    ) {
        introduceCard()
        onlySpringSpce(
            onClick = onlySpringSpecOnClick
        )
    }
}