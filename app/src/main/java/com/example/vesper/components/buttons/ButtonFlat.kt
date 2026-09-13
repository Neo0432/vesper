package com.example.vesper.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.vesper.designsystem.ui.theme.VesperTheme


enum class ButtonSize(
    val containerSize: Dp,
    val iconSize: Dp,
) {
    Small(containerSize = 32.dp, iconSize = 16.dp),
    Medium(containerSize = 36.dp, iconSize = 24.dp),
    Large(containerSize = 48.dp, iconSize = 26.dp)
}

@Composable
fun ButtonFlat(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    size: ButtonSize = ButtonSize.Medium,
    enabled: Boolean = true,
    iconColor: Color = MaterialTheme.colorScheme.onBackground
) {
    IconButton(
        onClick = onClick, shape = IconButtonDefaults.standardShape,
        enabled = enabled,
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = iconColor
        ),
        modifier = Modifier
            .size(size.containerSize)
            .then(modifier)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(size.iconSize)
        )
    }
}


@Preview
@Composable
fun ButtonFlatPreview() {
    VesperTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Small (32dp / 16dp)
            ButtonFlat(
                icon = Icons.Rounded.Settings,
                size = ButtonSize.Small,
                onClick = {}
            )

            // Medium (40dp / 22dp) — дефолтный размер, параметр size можно опустить
            ButtonFlat(
                icon = Icons.Rounded.Add,
                size = ButtonSize.Medium,
                onClick = {}
            )

            // Large (48dp / 26dp)
            ButtonFlat(
                icon = Icons.Rounded.Delete,
                size = ButtonSize.Large,
                onClick = {}
            )
        }
    }
}