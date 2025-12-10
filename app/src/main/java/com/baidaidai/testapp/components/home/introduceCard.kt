package com.baidaidai.testapp.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.baidaidai.testapp.R

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun introduceCard(){
    Card(
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.error,
            disabledContentColor = MaterialTheme.colorScheme.onError
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.createrbai),
                    contentDescription = "Avater",
                    modifier = Modifier
                        .size(100.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                ) {
                    Text("Author🔧: Creater. Bai")
                    Text("Github:xxxxxxx")
                }
            }
            HorizontalDivider(thickness = 1.dp)
            Column(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            ){
                Text("""This app is the final project from my journey learning Android Jetpack Compose. Its original purpose was to practice Compose syntax, Android development, and to help me remember the many Animation APIs in Jetpack. ✨

If this code has helped you, please don’t hesitate to ⭐️ star it on GitHub.

Wishing you a wonderful Android journey and endless inspiration! 🚀💡
                                """)
            }
        }
    }
}