package org.sopt.official.mds.components.chip

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MdsChip(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    type: MdsChipType = MdsChipType.OUTLINED,
    size: MdsChipSize = MdsChipSize.SMALL,
    @DrawableRes prefixIcon: Int? = null,
    @DrawableRes suffixIcon: Int? = null,
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .padding(horizontal = size.horizontalPadding, vertical = size.verticalPadding)
        ) {
            prefixIcon?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier.size(size.iconSize)
                )
            }

            Text(
                text = text,
                style = size.typography(),
                color = textColor
            )

            suffixIcon?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier.size(size.iconSize)
                )
            }
        }
    }
}
