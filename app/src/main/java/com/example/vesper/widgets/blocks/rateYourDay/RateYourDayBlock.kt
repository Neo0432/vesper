package com.example.vesper.widgets.blocks.rateYourDay

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vesper.components.SectionBlock
import com.example.vesper.components.buttons.SquareOutlinedButton
import com.example.vesper.components.buttons.SquareTextButton
import com.example.vesper.designsystem.ui.theme.SlateGreen50
import com.example.vesper.designsystem.ui.theme.SlateGreen80
import com.example.vesper.designsystem.ui.theme.VesperTheme
import com.example.vesper.designsystem.ui.theme.Yellow50
import java.time.LocalDate

val SliderActiveTrack = SlateGreen50
val SliderInactiveTrack = Yellow50
val SliderTick = SlateGreen80
val SliderThumb = SlateGreen50
val ExpandButtonContent = SlateGreen50
val SubmitButtonBorder = SlateGreen50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RateYourDayBlock(modifier: Modifier = Modifier) {
    val today = LocalDate.now()

    var sliderPosition by rememberSaveable { mutableFloatStateOf(3f) }
    val interactionSource = remember { MutableInteractionSource() }
    var isOptionalExpanded by rememberSaveable { mutableStateOf(false) }

    val sliderColors = SliderDefaults.colors(
        thumbColor = SliderThumb,
        activeTrackColor = SliderActiveTrack,
        inactiveTrackColor = SliderInactiveTrack,
        activeTickColor = SliderTick,
        inactiveTickColor = SliderTick,
    )


    SectionBlock(
        title = "Rate your day",
        modifier = modifier,
        rightHeaderSlot = { Text(today.toString(), style = typography.labelMedium) },
        footer = {
            RateYourDayBlockFooter(
                isExpanded = isOptionalExpanded,
                onExpand = { isOptionalExpanded = !isOptionalExpanded },
                onSubmit = {})
        }
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 3,
            interactionSource = interactionSource,
            valueRange = 1f..5f,
            colors = sliderColors,
            //TODO: Сделать кастомный thumb с тултипом,
            // который будет подписывать что означает выбранная позиция
            thumb = {
                SliderDefaults.Thumb(
                    interactionSource = interactionSource,
                    colors = sliderColors,
                    thumbSize = androidx.compose.ui.unit.DpSize(4.dp, 40.dp)
                )
            },

            track = { sliderState ->
                SliderDefaults.Track(
                    sliderState = sliderState,
                    colors = sliderColors,
                    modifier = Modifier.height(24.dp)
                )
            }
        )
    }
}

@Composable
fun RateYourDayBlockFooter(isExpanded: Boolean, onExpand: () -> Unit, onSubmit: () -> Unit) {
    val rotation by animateFloatAsState(
        targetValue = if (isExpanded) -180f else 0f,
        label = "optional_arrow_rotation"
    )

    val defaultPadding = ButtonDefaults.TextButtonContentPadding

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SquareTextButton(
            onClick = onExpand,
            contentPadding = PaddingValues(
                start = 2.dp,
                top = defaultPadding.calculateTopPadding(),
                end = 8.dp,
                bottom = defaultPadding.calculateBottomPadding()
            ),
        ) {
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.rotate(rotation)
            )

            Text("Optional")
        }

        SquareOutlinedButton(onClick = onSubmit) {
            Text("Submit", style = typography.labelMedium)
        }
    }
}

@Preview
@Composable
fun RateYourDayBlockPreview() {
    VesperTheme() {
        RateYourDayBlock()
    }
}