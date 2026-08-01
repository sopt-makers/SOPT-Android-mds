package org.sopt.official.mds.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp

@Composable
fun MdsActionButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    type: MdsActionButtonType = MdsActionButtonType.PRIMARY,
    size: MdsActionButtonSize = MdsActionButtonSize.XSMALL,
    @DrawableRes prefixIcon: Int? = null,
    @DrawableRes suffixIcon: Int? = null,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val colors = type.colors()
    val (backgroundColor, textColor) = when {
        !enabled -> colors.disabledBackground to colors.disabledText
        pressed -> colors.pressedBackground to colors.pressedText
        else -> colors.background to colors.text
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(size.shape)
            .background(backgroundColor)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = size.horizontalPadding, vertical = size.verticalPadding)
    ) {
        prefixIcon?.let {
            ActionButtonIcon(it, textColor, size.iconSize)
        }

        Text(
            text = text,
            style = size.textStyle(),
            color = textColor,
            textAlign = TextAlign.Center,
        )

        suffixIcon?.let {
            ActionButtonIcon(it, textColor, size.iconSize)
        }
    }
}

@Composable
private fun ActionButtonIcon(
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
