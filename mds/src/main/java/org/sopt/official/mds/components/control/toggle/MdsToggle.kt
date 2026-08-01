package org.sopt.official.mds.components.control.toggle

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun MdsToggle(
    selected: Boolean,
    size: MdsToggleSize,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: (Boolean) -> Unit
) {
    val padding = 2.dp
    val colors = MdsToggleDefaults.colors(enabled)

    val thumbOffset by animateDpAsState(
        targetValue = if (selected) {
            size.toggleWidth - size.thumbWidth - padding * 2
        } else {
            0.dp
        },
        animationSpec = tween(
            durationMillis = 180,
            easing = FastOutSlowInEasing
        )
    )

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = modifier
            .width(size.toggleWidth)
            .clip(CircleShape)
            .background(if (selected) colors.selectedColor else colors.unselectedColor)
            .padding(vertical = padding)
            .clickable(
                enabled = enabled,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onClick(!selected)
            }
    ) {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset + padding)
                .size(size.thumbWidth)
                .clip(CircleShape)
                .background(colors.thumbColor)
        )
    }
}
