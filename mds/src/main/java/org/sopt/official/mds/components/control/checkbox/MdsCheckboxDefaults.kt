package org.sopt.official.mds.components.control.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.sopt.official.mds.theme.SoptTheme

object MdsCheckboxDefaults {
    @Composable
    fun colors(
        selected: Boolean,
        enabled: Boolean
    ): MdsCheckboxColors = if (enabled) {
        if (selected) {
            MdsCheckboxColors(
                backgroundColor = SoptTheme.colors.fg.secondary.default,
                strokeColor = null,
                textColor = SoptTheme.colors.fg.neutral.bold,
                iconColor = SoptTheme.colors.fg.neutral.bold
            )
        } else {
            MdsCheckboxColors(
                backgroundColor = null,
                strokeColor = SoptTheme.colors.stroke.neutral.default,
                textColor = SoptTheme.colors.fg.neutral.bold,
                iconColor = null
            )
        }
    } else {
        if (selected) {
            MdsCheckboxColors(
                backgroundColor = SoptTheme.colors.fg.neutral.ghostDisabled,
                strokeColor = null,
                textColor = SoptTheme.colors.fg.neutral.ghost,
                iconColor = SoptTheme.colors.fg.neutral.ghost
            )
        } else {
            MdsCheckboxColors(
                backgroundColor = null,
                strokeColor = SoptTheme.colors.stroke.neutral.defaultDisabled,
                textColor = SoptTheme.colors.fg.neutral.defaultDisabled,
                iconColor = null
            )
        }
    }
}

data class MdsCheckboxColors(
    val backgroundColor: Color?,
    val strokeColor: Color?,
    val textColor: Color,
    val iconColor: Color?
)