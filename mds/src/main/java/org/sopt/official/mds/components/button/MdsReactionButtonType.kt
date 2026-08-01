package org.sopt.official.mds.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.sopt.official.mds.theme.SoptTheme

enum class MdsReactionButtonType() {
    SELECTED,
    UNSELECTED;

    @Composable
    fun colors(size: MdsReactionButtonSize): MdsButtonColors = when (this) {
        SELECTED -> MdsButtonColors(
            background = Color.Transparent,
            pressedBackground = Color.Transparent,
            disabledBackground = if (size == MdsReactionButtonSize.XSMALL) Color.Transparent else SoptTheme.colors.bg.neutral.defaultDisabled,
            stroke = SoptTheme.colors.stroke.neutral.default,
            pressedStroke = SoptTheme.colors.stroke.neutral.defaultFocused,
            disabledStroke = SoptTheme.colors.stroke.neutral.defaultDisabled,
            text = SoptTheme.colors.fg.neutral.bold,
            pressedText = SoptTheme.colors.fg.neutral.bold,
            disabledText = SoptTheme.colors.fg.neutral.defaultDisabled
        )

        UNSELECTED -> MdsButtonColors(
            background = Color.Transparent,
            pressedBackground = Color.Transparent,
            disabledBackground = if (size == MdsReactionButtonSize.XSMALL) Color.Transparent else SoptTheme.colors.bg.neutral.defaultDisabled,
            stroke = SoptTheme.colors.stroke.neutral.default,
            pressedStroke = SoptTheme.colors.stroke.neutral.defaultFocused,
            disabledStroke = SoptTheme.colors.stroke.neutral.defaultDisabled,
            text = SoptTheme.colors.fg.neutral.default,
            pressedText = SoptTheme.colors.fg.neutral.default,
            disabledText = SoptTheme.colors.fg.neutral.defaultDisabled
        )
    }
}
