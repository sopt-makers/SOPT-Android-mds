package org.sopt.official.mds.components.chip

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.theme.SoptTheme

enum class MdsChipSize(
    val verticalPadding: Dp,
    val horizontalPadding: Dp,
    val iconSize: Dp
) {
    SMALL(
        verticalPadding = 9.dp,
        horizontalPadding = 14.dp,
        iconSize = 16.dp
    ),
    MEDIUM(
        verticalPadding = 10.dp,
        horizontalPadding = 20.dp,
        iconSize = 20.dp
    );

    @Composable
    internal fun typography(): TextStyle {
        return when (this) {
            SMALL -> SoptTheme.typography.label3
            MEDIUM -> SoptTheme.typography.label2
        }
    }
}
