package org.sopt.official.mds.components.tag

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MdsTag(
    text: String,
    modifier: Modifier = Modifier,
    type: MdsTagType = MdsTagType.DEFAULT,
    emphasis: MdsTagEmphasis = MdsTagEmphasis.SOLID,
    size: MdsTagSize = MdsTagSize.SMALL,
    shape: MdsTagShape = MdsTagShape.RECT,
    @DrawableRes icon: Int? = null
) {
    val colors = MdsTagDefaults.colors(type, emphasis)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
            .clip(shape.shape)
            .background(colors.backgroundColor)
            .padding(vertical = 4.dp, horizontal = 8.dp)

    ) {
        icon?.let {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = colors.textColor,
                modifier = Modifier.size(size.iconSize)
            )
        }

        Text(
            text = text,
            style = size.typography(),
            color = colors.textColor
        )
    }
}
