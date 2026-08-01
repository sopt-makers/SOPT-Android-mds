package org.sopt.official.mds.components.button

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.theme.SoptTheme

enum class MdsActionButtonSize(
    val iconSize: Dp,
    val horizontalPadding: Dp,
    val verticalPadding: Dp,
    val spacedBy: Dp,
    val shape: Shape
) {
    XSMALL(
        iconSize = 16.dp,
        horizontalPadding = 12.dp,
        verticalPadding = 8.dp,
        spacedBy = 2.dp,
        shape = CircleShape
    ),
    SMALL(
        iconSize = 16.dp,
        horizontalPadding = 12.dp,
        verticalPadding = 10.dp,
        spacedBy = 4.dp,
        shape = RoundedCornerShape(SoptTheme.radius.r8)
    ),
    MEDIUM(
        iconSize = 20.dp,
        horizontalPadding = 16.dp,
        verticalPadding = 12.dp,
        spacedBy = 4.dp,
        shape = RoundedCornerShape(SoptTheme.radius.r10)
    ),
    LARGE(
        iconSize = 24.dp,
        horizontalPadding = 20.dp,
        verticalPadding = 16.dp,
        spacedBy = 4.dp,
        shape = RoundedCornerShape(SoptTheme.radius.r12)
    );

    @Composable
    fun textStyle(): TextStyle =
        when (this) {
            XSMALL -> SoptTheme.typography.label4
            SMALL -> SoptTheme.typography.label3
            MEDIUM -> SoptTheme.typography.label2
            LARGE -> SoptTheme.typography.label1
        }
}
