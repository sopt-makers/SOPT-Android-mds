package org.sopt.official.mds.components.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.R
import org.sopt.official.mds.theme.SoptTheme

@Composable
fun MdsTextButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    type: MdsTextButtonType = MdsTextButtonType.DEFAULT,
    size: MdsTextButtonSize = MdsTextButtonSize.SMALL,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val color = when {
        !enabled -> SoptTheme.colors.fg.neutral.defaultDisabled
        type == MdsTextButtonType.DEFAULT -> SoptTheme.colors.fg.neutral.default
        else -> SoptTheme.colors.fg.neutral.bold
    }

    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = size.textStyle(),
                color = color
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_right_outlined),
                contentDescription = null,
                tint = color,
                modifier = Modifier
                    .size(size.iconSize)
            )
        }

        HorizontalDivider(
            color = if (pressed) color else Color.Transparent,
            thickness = 1.dp
        )
    }
}
