package org.sopt.official.mds.components.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
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

    val color = when {
        !enabled -> SoptTheme.colors.fg.neutral.defaultDisabled
        type == MdsTextButtonType.DEFAULT -> SoptTheme.colors.fg.neutral.default
        else -> SoptTheme.colors.fg.neutral.bold
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
    ) {
        Text(
            text = text,
            style = size.textStyle(),
            color = color,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_right_outlined),
            contentDescription = null,
            tint = color,
            modifier = Modifier
                .size(size.iconSize)
        )
    }
}
