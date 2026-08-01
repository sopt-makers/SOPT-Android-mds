package org.sopt.official.mds.components.control.radio

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.theme.SoptTheme

enum class MdsRadioSize(
    val touchTargetSize: Dp,
    val buttonSize: Dp,
    val indicatorSize: Dp,
    val spacing: Dp,
) {
    SMALL(
        touchTargetSize = 22.dp,
        buttonSize = 16.dp,
        indicatorSize = 8.dp,
        spacing = 4.dp
    ),
    LARGE(
        touchTargetSize = 26.dp,
        buttonSize = 22.dp,
        indicatorSize = 10.dp,
        spacing = 8.dp
    );

    @Composable
    fun typography() = when (this) {
        SMALL -> SoptTheme.typography.label.l3
        LARGE -> SoptTheme.typography.label.l2
    }
}
