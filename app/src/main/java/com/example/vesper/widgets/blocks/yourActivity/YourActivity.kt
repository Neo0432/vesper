package com.example.vesper.widgets.blocks.yourActivity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vesper.components.SectionBlock
import com.example.vesper.designsystem.ui.theme.DayRateBreezy
import com.example.vesper.designsystem.ui.theme.DayRateHeavy
import com.example.vesper.designsystem.ui.theme.DayRateLight
import com.example.vesper.designsystem.ui.theme.DayRateMedium
import com.example.vesper.designsystem.ui.theme.DayRateModerate
import com.example.vesper.designsystem.ui.theme.VesperTheme

@Composable
fun YourActivity(modifier: Modifier = Modifier) {
    SectionBlock(
        title = "Rate your day",
        modifier = modifier,
        footer = {}
    ) {}
}

@Composable
fun YourActivityFooter() {
    val colors =
        listOf(DayRateHeavy, DayRateModerate, DayRateMedium, DayRateBreezy, DayRateLight)
    Row(
        horizontalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.End),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Heavy")

        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            colors.forEach {
                Box(
                    Modifier
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(color = it)
                        .size(16.dp)
                )
            }
        }

        Text("Light")
    }
}

@Preview
@Composable
fun YourActivityFooterPreview() {
    VesperTheme() {
        YourActivityFooter()
    }
}