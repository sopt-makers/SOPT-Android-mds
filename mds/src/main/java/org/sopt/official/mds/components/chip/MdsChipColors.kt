package org.sopt.official.mds.components.chip

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class MdsChipColors(
    val background: Color,
    val selectedBackground: Color,
    val disabledBackground: Color,

    val stroke: Color?,
    val selectedStroke: Color?,
    val disabledStroke: Color?,

    val text: Color,
    val selectedText: Color,
    val disabledText: Color
)
