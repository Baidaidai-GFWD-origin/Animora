package com.baidaidai.testapp.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun onlySpringSpce(){
    Card(
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.error,
            disabledContentColor = MaterialTheme.colorScheme.onError
        ),
        modifier = Modifier
            .padding(top = 20.dp)
            .clickable(
                onClick = {}
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Icon(Icons.Outlined.QuestionMark, contentDescription = "Question LOGO")
                    Text(
                        text = "Only For SpringSpec?",
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
                Icon(Icons.Outlined.ArrowForwardIos, contentDescription = "Go SpringSpec")
            }
        }
    }
}