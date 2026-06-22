package org.sopt.official.mds.components.button

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.R
import org.sopt.official.mds.theme.SoptTheme

private const val ROTATE_DURATION = 600

@Composable
fun MdsFloatingButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    enabled: Boolean = true,
    type: MdsFloatingButtonType = MdsFloatingButtonType.DEFAULT,
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

    var isRotated by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (isRotated) 45f else 0f,
        animationSpec = tween(durationMillis = ROTATE_DURATION, easing = FastOutSlowInEasing)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    onClick()
                    if (type == MdsFloatingButtonType.DEFAULT) {
                        isRotated = !isRotated
                    }
                }
            )
            .padding(horizontal = type.horizontalPadding, vertical = type.verticalPadding)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_plus_outlined),
            contentDescription = null,
            tint = textColor,
            modifier = Modifier
                .size(type.iconSize)
                .then(
                    if (type == MdsFloatingButtonType.DEFAULT) Modifier.rotate(rotation) else Modifier
                )
        )

        if (type.showText && text != null) {
            Text(
                text = text,
                style = SoptTheme.typography.label.l1,
                color = textColor
            )
        }
    }
}
