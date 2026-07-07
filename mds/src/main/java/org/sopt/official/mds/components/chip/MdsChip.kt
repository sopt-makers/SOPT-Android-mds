package org.sopt.official.mds.components.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MdsChip(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    type: MdsChipType = MdsChipType.OUTLINED,
    size: MdsChipSize = MdsChipSize.SMALL,
    onClick: () -> Unit
) {
    val colors = type.colors()
    val (textColor, backgroundColor, strokeColor) = when {
        !enabled -> Triple(colors.disabledText, colors.disabledBackground, colors.disabledStroke)
        selected -> Triple(colors.selectedText, colors.selectedBackground, colors.selectedStroke)
        else -> Triple(colors.text, colors.background, colors.stroke)
    }

    Surface(
        shape = CircleShape,
        color = backgroundColor,
        border = strokeColor?.let { BorderStroke(1.dp, it) },
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = size.typography(),
            color = textColor,
            modifier = Modifier
                .padding(horizontal = size.horizontalPadding, vertical = size.verticalPadding)
        )
    }
}
