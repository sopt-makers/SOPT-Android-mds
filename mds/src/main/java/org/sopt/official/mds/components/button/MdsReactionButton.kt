package org.sopt.official.mds.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MdsReactionButton(
    text: String,
    reactionCount: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    type: MdsReactionButtonType = MdsReactionButtonType.SELECTED,
    size: MdsReactionButtonSize = MdsReactionButtonSize.XSMALL,
    @DrawableRes prefixIcon: Int? = null,
    @DrawableRes suffixIcon: Int? = null,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val colors = type.colors(size)
    val (backgroundColor, strokeColor, textColor) = when {
        !enabled -> Triple(colors.disabledBackground, colors.disabledStroke, colors.disabledText)
        pressed -> Triple(colors.pressedBackground, colors.pressedStroke, colors.pressedText)
        else -> Triple(colors.background, colors.stroke, colors.text)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(size.spacedBy),
        modifier = modifier
            .then(
                if (size == MdsReactionButtonSize.XSMALL) Modifier
                else Modifier.border(
                    width = 1.dp,
                    color = strokeColor,
                    shape = CircleShape
                )
            )
            .background(backgroundColor, CircleShape)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = size.horizontalPadding, vertical = size.verticalPadding)
    ) {
        prefixIcon?.let {
            ReactionButtonIcon(it, textColor, size.iconSize)
        }

        Text(
            text = text,
            style = size.textStyle(),
            color = textColor
        )

        Text(
            text = reactionCount.toString(),
            style = size.textStyle().copy(
                fontFeatureSettings = "tnum"
            ),
            color = textColor
        )

        suffixIcon?.let {
            ReactionButtonIcon(it, textColor, size.iconSize)
        }
    }
}

@Composable
private fun ReactionButtonIcon(
    @DrawableRes icon: Int,
    tint: Color,
    size: Dp,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(icon),
        contentDescription = null,
        tint = tint,
        modifier = modifier.size(size)
    )
}
