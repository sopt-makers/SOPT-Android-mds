package org.sopt.official.mds.components.control.toggle

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.sopt.official.mds.theme.SoptTheme

object MdsToggleDefaults {
    @Composable
    fun colors(
        enabled: Boolean
    ): MdsToggleColors = if (enabled) {
        MdsToggleColors(
            selectedColor = SoptTheme.colors.fg.secondary.default,
            unselectedColor = SoptTheme.colors.fg.neutral.ghost,
            thumbColor = SoptTheme.colors.fg.neutral.bold
        )
    } else {
        MdsToggleColors(
            selectedColor = SoptTheme.colors.fg.neutral.ghostDisabled,
            unselectedColor = SoptTheme.colors.fg.neutral.ghostDisabled,
            thumbColor = SoptTheme.colors.fg.neutral.defaultDisabled
        )
    }
}

data class MdsToggleColors(
    val selectedColor: Color,
    val unselectedColor: Color,
    val thumbColor: Color
)