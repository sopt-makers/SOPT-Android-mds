package org.sopt.official.mds.components.control.radio

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MdsRadio(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    size: MdsRadioSize = MdsRadioSize.SMALL,
    enabled: Boolean = true,
    onClick: () -> Unit
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
                .size(size.touchTargetSize)
                .clickable(enabled = enabled, onClick = onClick)
                .clip(CircleShape)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(size.buttonSize)
                    .then(
                        if (selected) {
                            Modifier.background(
                                colors.buttonColor ?: Color.Transparent,
                                CircleShape
                            )
                        } else {
                            Modifier.border(
                                1.dp,
                                colors.strokeColor ?: Color.Transparent,
                                CircleShape
                            )
                        }
                    )
            ) {
                colors.indicatorColor?.let {
                    Box(
                        Modifier
                            .size(size.indicatorSize)
                            .background(colors.indicatorColor, CircleShape)
                    )
                }
            }
        }

        Text(
            text = text,
            style = size.typography(),
            color = colors.textColor
        )
    }
}
