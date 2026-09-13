package com.example.vesper.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vesper.components.buttons.ButtonFlat
import com.example.vesper.designsystem.ui.theme.MainBackgroundGradient
import com.example.vesper.designsystem.ui.theme.VesperTheme
import com.example.vesper.widgets.blocks.rateYourDay.RateYourDayBlock

@Composable
fun HomeScreen() {
    val helloLabel = "Good Evening!"


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBackgroundGradient)
    )
    {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = { MainScreenHeader(helloLabel) }) { innerPadding ->
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                RateYourDayBlock(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun MainScreenHeader(helloLabel: String) {
    Row(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .fillMaxWidth()
            .padding(top = 48.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            helloLabel,
            color = MaterialTheme.colorScheme.onBackground,
            style = typography.titleLarge
        )
        ButtonFlat(
            icon = Icons.Outlined.Settings,
            onClick = {},
            modifier = Modifier.size(36.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    VesperTheme() {
        HomeScreen()
    }
}