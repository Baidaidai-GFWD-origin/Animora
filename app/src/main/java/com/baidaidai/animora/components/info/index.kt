package com.baidaidai.animora.components.info

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.baidaidai.animora.R
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
            OutlinedCard {
                /* Icon && App Name */
                Column {
                    Text(
                        text = "Info Area",
                        modifier = Modifier
                            .padding(start = 15.dp, top = 10.dp),
                        style = MaterialTheme.typography.titleSmall,
                    )
                    ListItem(
                        headlineContent = {
                            Text("App Version")
                        },
                        supportingContent = {
                            Text("v_0.5.0")
                        },
                        leadingContent = {
                            Icon(
                                painter = painterResource(R.drawable.outline_apk_document_24),
                                contentDescription = "Application Version Icons"
                            )
                        }
                    )
                    ListItem(
                        headlineContent = {
                            Text("View in Github")
                        },
                        leadingContent = {
                            Icon(
                                painter = painterResource(R.drawable.github),
                                contentDescription = "View in Github"
                            )
                        }
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .size(height = 10.dp, width = 1.dp)
            )
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
                                contentDescription = "Application Version Icons"
                            )
                        }
                    )
                    ListItem(
                        headlineContent = {
                            Text("Follow my Github")
                        },
                        leadingContent = {
                            Icon(
                                painter = painterResource(R.drawable.github),
                                contentDescription = "Application Version Icons"
                            )
                        }
                    )
                }
            }
        }
    }
}

//@PreviewLightDark
//@Composable
//private fun infoScreenPreview(){
//    infoScreen()
//}