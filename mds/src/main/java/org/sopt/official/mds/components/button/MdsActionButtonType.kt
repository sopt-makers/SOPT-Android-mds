package org.sopt.official.mds.components.button

import androidx.compose.runtime.Composable
import org.sopt.official.mds.theme.SoptTheme

enum class MdsActionButtonType {
    PRIMARY,
    SECONDARY,
    DANGER;

    @Composable
    fun colors(): MdsButtonColors = when (this) {
        PRIMARY -> MdsButtonColors(
            background = SoptTheme.colors.bg.neutral.inverse,
            pressedBackground = SoptTheme.colors.bg.neutral.inversePressed,
            disabledBackground = SoptTheme.colors.bg.neutral.defaultDisabled,
            text = SoptTheme.colors.fg.neutral.inverse,
            disabledText = SoptTheme.colors.fg.neutral.defaultDisabled
        )

        SECONDARY -> MdsButtonColors(
            background = SoptTheme.colors.bg.neutral.subtle,
            pressedBackground = SoptTheme.colors.bg.neutral.subtlePressed,
            disabledBackground = SoptTheme.colors.bg.neutral.defaultDisabled,
            text = SoptTheme.colors.fg.neutral.bold,
            disabledText = SoptTheme.colors.fg.neutral.defaultDisabled
        )

        DANGER -> MdsButtonColors(
            background = SoptTheme.colors.bg.danger.default,
            pressedBackground = SoptTheme.colors.bg.danger.defaultPressed,
            disabledBackground = SoptTheme.colors.bg.neutral.defaultDisabled,
            text = SoptTheme.colors.fg.neutral.bold,
            disabledText = SoptTheme.colors.fg.neutral.defaultDisabled
        )
    }
}
