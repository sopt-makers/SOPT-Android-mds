package org.sopt.official.mds.components.control.toggle

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class MdsToggleSize(
    val toggleWidth: Dp,
    val thumbWidth: Dp
) {
    SMALL(26.dp, 12.dp),
    LARGE(36.dp, 16.dp)
}
