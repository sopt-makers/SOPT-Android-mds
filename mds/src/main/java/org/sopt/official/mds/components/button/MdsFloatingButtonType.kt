package org.sopt.official.mds.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.theme.SoptTheme

enum class MdsFloatingButtonType(
    val iconSize: Dp,
    val horizontalPadding: Dp,
    val verticalPadding: Dp,
    val showText: Boolean,
) {
    DEFAULT(
        iconSize = 28.dp,
        horizontalPadding = 10.dp,
        verticalPadding = 10.dp,
        showText = false
    ),
    EXPANDED(
        iconSize = 24.dp,
        horizontalPadding = 14.dp,
        verticalPadding = 12.dp,
        showText = true
    );

    @Composable
    fun colors(): MdsButtonColors = MdsButtonColors(
        background = SoptTheme.colors.bg.neutral.inverse,
        pressedBackground = SoptTheme.colors.bg.neutral.inversePressed,
        disabledBackground = SoptTheme.colors.bg.neutral.defaultDisabled,
        stroke = Color.Transparent,
        pressedStroke = Color.Transparent,
        disabledStroke = Color.Transparent,
        text = SoptTheme.colors.fg.neutral.inverse,
        pressedText = SoptTheme.colors.fg.neutral.inverse,
        disabledText = SoptTheme.colors.fg.neutral.defaultDisabled
    )
}
