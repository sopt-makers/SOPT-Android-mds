package org.sopt.official.mds.components.control.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.R

@Composable
fun MdsCheckbox(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    size: MdsCheckboxSize = MdsCheckboxSize.SMALL,
    enabled: Boolean = true,
    onClick: (Boolean) -> Unit
) {
    val colors = MdsCheckboxDefaults.colors(selected, enabled)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(size.spacing),
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(2.dp)
                .clickable(enabled = enabled) {
                    onClick(!selected)
                }
                .clip(RoundedCornerShape(4.dp))
                .background(
                    color = colors.backgroundColor ?: Color.Transparent,
                    shape = RoundedCornerShape(4.dp)
                )
                .border(
                    width = 1.dp,
                    color = colors.strokeColor ?: Color.Transparent,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(2.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_check_outlined),
                contentDescription = null,
                tint = colors.iconColor ?: Color.Transparent,
                modifier = Modifier
                    .size(size.iconSize)
            )
        }

        Text(
            text = text,
            style = size.typography(),
            color = colors.textColor
        )
    }
}
