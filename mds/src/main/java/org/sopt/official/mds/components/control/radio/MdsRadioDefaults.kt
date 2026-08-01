package org.sopt.official.mds.components.control.radio

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.sopt.official.mds.theme.SoptTheme

object MdsCheckboxDefaults {
    @Composable
    fun colors(
        selected: Boolean,
        enabled: Boolean
    ): MdsRadioColors = if (enabled) {
        if (selected) {
            MdsRadioColors(
                buttonColor = SoptTheme.colors.fg.secondary.default,
                indicatorColor = SoptTheme.colors.fg.neutral.bold,
                strokeColor = null,
                textColor = SoptTheme.colors.fg.neutral.bold
            )
        } else {
            MdsRadioColors(
                buttonColor = null,
                indicatorColor = null,
                strokeColor = SoptTheme.colors.stroke.neutral.default,
                textColor = SoptTheme.colors.fg.neutral.bold
            )
        }
    } else {
        if (selected) {
            MdsRadioColors(
                buttonColor = SoptTheme.colors.fg.neutral.ghostDisabled,
                indicatorColor = SoptTheme.colors.fg.neutral.ghost,
                strokeColor = null,
                textColor = SoptTheme.colors.fg.neutral.defaultDisabled
            )
        } else {
            MdsRadioColors(
                buttonColor = null,
                indicatorColor = null,
                strokeColor = SoptTheme.colors.stroke.neutral.defaultDisabled,
                textColor = SoptTheme.colors.fg.neutral.defaultDisabled
            )
        }
    }
}

data class MdsRadioColors(
    val buttonColor: Color?,
    val indicatorColor: Color?,
    val strokeColor: Color?,
    val textColor: Color
)