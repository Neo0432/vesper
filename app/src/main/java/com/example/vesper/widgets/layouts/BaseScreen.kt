package com.example.vesper.widgets.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    title: String,
    description: String?,
    rightHeaderSlot: (@Composable () -> Unit)? = null,
    footer: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Scaffold(topBar = { BaseScreenHeader(title = "Settings") }) { innerPadding ->

    }
}


@Composable
fun BaseScreenHeader(
    title: String,
    leftHeaderSlot: (@Composable () -> Unit)? = null,
    rightHeaderSlot: (@Composable () -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title)
    }
}