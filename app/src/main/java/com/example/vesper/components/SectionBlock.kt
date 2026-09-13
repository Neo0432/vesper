package com.example.vesper.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vesper.designsystem.ui.theme.VesperTheme

@Composable
fun SectionBlock(
    modifier: Modifier = Modifier,
    title: String,
    description: String? = null,
    rightHeaderSlot: (@Composable () -> Unit)? = null,
    footer: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .animateContentSize()
            .then(modifier)

    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        title,
                        style = typography.titleSmall,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    if (description != null) Text(
                        description,
                        style = typography.labelMedium,
                        color = MaterialTheme.colorScheme.onTertiary,
                    )
                }

                rightHeaderSlot?.invoke()
            }

            content()
            footer?.invoke()
        }
    }
}

@Preview()
@Composable
fun SectionPreview() {
    VesperTheme {
        SectionBlock(
            title = "Victories for the day",
            description = "Small or big things that went well"
        ) { }
    }
}