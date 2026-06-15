package org.sopt.official.mds.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import org.sopt.official.mds.foundation.base.size16
import org.sopt.official.mds.foundation.base.size18
import org.sopt.official.mds.theme.SoptTheme

enum class MdsTextButtonSize(
    val iconSize: Dp
) {
    SMALL(size16),
    MEDIUM(size18);

    @Composable
    fun textStyle(): TextStyle =
        when (this) {
            SMALL -> SoptTheme.typography.label.l4
            MEDIUM -> SoptTheme.typography.label.l3
        }
}
