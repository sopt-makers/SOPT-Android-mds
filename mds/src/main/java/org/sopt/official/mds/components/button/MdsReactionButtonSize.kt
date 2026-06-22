package org.sopt.official.mds.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.theme.SoptTheme

enum class MdsReactionButtonSize(
    val iconSize: Dp,
    val horizontalPadding: Dp,
    val verticalPadding: Dp,
    val spacedBy: Dp
) {
    XSMALL(
        iconSize = 16.dp,
        horizontalPadding = 12.dp,
        verticalPadding = 2.dp,
        spacedBy = 4.dp
    ),
    SMALL(
        iconSize = 16.dp,
        horizontalPadding = 14.dp,
        verticalPadding = 8.dp,
        spacedBy = 4.dp
    ),
    MEDIUM(
        iconSize = 20.dp,
        horizontalPadding = 16.dp,
        verticalPadding = 10.dp,
        spacedBy = 4.dp
    ),
    LARGE(
        iconSize = 24.dp,
        horizontalPadding = 24.dp,
        verticalPadding = 15.dp,
        spacedBy = 6.dp
    );

    @Composable
    fun textStyle(): TextStyle =
        when (this) {
            XSMALL -> SoptTheme.typography.label.l4
            SMALL -> SoptTheme.typography.label.l4
            MEDIUM -> SoptTheme.typography.label.l3
            LARGE -> SoptTheme.typography.label.l1
        }
}
