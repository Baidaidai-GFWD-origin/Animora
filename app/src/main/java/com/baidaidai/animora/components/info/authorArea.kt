package com.baidaidai.animora.components.info

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.baidaidai.animora.R

@Composable
fun authorAreaContainer(
    onClickGithub:()-> Unit,
    onClickTwitter: () -> Unit
){
    OutlinedCard {
        Column {
            Text(
                text = "Author Area",
                modifier = Modifier
                    .padding(start = 15.dp, top = 10.dp),
                style = MaterialTheme.typography.titleSmall,
            )
            ListItem(
                headlineContent = {
                    Text("Author")
                },
                supportingContent = {
                    Text("Creater. Bai")
                },
                leadingContent = {
                    Icon(
                        Icons.Outlined.Person,
                        contentDescription = "Application Version Icons"
                    )
                }
            )
            ListItem(
                headlineContent = {
                    Text("Follow my Twitter")
                },
                leadingContent = {
                    Icon(
                        painter = painterResource(R.drawable.twitter),
                        contentDescription = "Application Version Icons",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(2.dp)
                    )
                },
                modifier = Modifier
                    .clickable(onClick = onClickTwitter)
            )
            ListItem(
                headlineContent = {
                    Text("Follow my Github")
                },
                leadingContent = {
                    Icon(
                        painter = painterResource(R.drawable.github),
                        contentDescription = "Application Version Icons",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(2.dp)
                    )
                },
                modifier = Modifier
                    .clickable(onClick = onClickGithub)
            )
        }
    }
}