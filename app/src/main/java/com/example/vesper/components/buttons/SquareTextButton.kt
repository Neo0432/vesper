package com.example.vesper.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.vesper.widgets.blocks.rateYourDay.ExpandButtonContent

@Composable
fun SquareTextButton(
    onClick: () -> Unit,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    content: @Composable () -> Unit,
) {

    val expandButtonColors = ButtonDefaults.textButtonColors(
        contentColor = ExpandButtonContent,
    )

    TextButton(
        onClick = onClick,
        contentPadding = contentPadding,
        shape = RoundedCornerShape(12.dp),
        colors = expandButtonColors
    ) {
        content()
    }
}