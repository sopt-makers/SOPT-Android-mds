package org.sopt.official.mds.components.chip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.sopt.official.mds.theme.SoptTheme

enum class MdsChipType {
    OUTLINED,
    SOLID;

    @Composable
    internal fun colors(): MdsChipColors =
        when (this) {
            OUTLINED -> MdsChipColors(
                background = SoptTheme.colors.bg.neutral.ghost,
                selectedBackground = SoptTheme.colors.bg.neutral.subtle,
                disabledBackground = SoptTheme.colors.bg.neutral.ghost,
                stroke = SoptTheme.colors.stroke.neutral.subtle,
                selectedStroke = SoptTheme.colors.stroke.neutral.inverse,
                disabledStroke = SoptTheme.colors.stroke.neutral.defaultDisabled,
                text = SoptTheme.colors.fg.neutral.default,
                selectedText = SoptTheme.colors.fg.neutral.bold,
                disabledText = SoptTheme.colors.fg.neutral.ghost
            )

            SOLID -> MdsChipColors(
                background = SoptTheme.colors.bg.neutral.ghost,
                selectedBackground = SoptTheme.colors.bg.neutral.inverse,
                disabledBackground = SoptTheme.colors.bg.neutral.ghost,
                stroke = null,
                selectedStroke = null,
                disabledStroke = null,
                text = SoptTheme.colors.fg.neutral.default,
                selectedText = SoptTheme.colors.fg.neutral.inverse,
                disabledText = SoptTheme.colors.fg.neutral.ghost
            )
        }
}
