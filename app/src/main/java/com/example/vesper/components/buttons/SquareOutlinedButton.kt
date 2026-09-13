package com.example.vesper.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vesper.designsystem.ui.theme.VesperTheme
import com.example.vesper.widgets.blocks.rateYourDay.SubmitButtonBorder

@Composable
fun SquareOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier,
        border = BorderStroke(
            width = 1.dp,
            color = SubmitButtonBorder,
        )
    ) {
        content()
    }
}

@Preview
@Composable
fun SquareOutlinedButtonPreview() {
    VesperTheme() {
        SquareOutlinedButton(onClick = {}) {
            Text("Submit")
        }
    }
}