package org.sopt.official.mds.components.control.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.theme.SoptTheme

enum class MdsCheckboxSize(
    val size: Dp,
    val iconSize: Dp,
    val spacing: Dp
) {
    SMALL(20.dp, 12.dp, 4.dp),
    LARGE(24.dp, 14.dp, 8.dp);

    @Composable
    fun typography() = when (this) {
        SMALL -> SoptTheme.typography.label.l3
        LARGE -> SoptTheme.typography.label.l2
    }
}
