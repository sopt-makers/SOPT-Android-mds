package org.sopt.official.mds.foundation.semantic

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class MdsTypography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val heading3: TextStyle,
    val heading4: TextStyle,

    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title4: TextStyle,
    val title5: TextStyle,

    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,

    val label1: TextStyle,
    val label2: TextStyle,
    val label3: TextStyle,
    val label4: TextStyle
)
