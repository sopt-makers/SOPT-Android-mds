package org.sopt.official.mds.components.button

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class MdsButtonColors(
    val background: Color,
    val pressedBackground: Color,
    val disabledBackground: Color,

    val strokeColor: Color,
    val pressedStrokeColor: Color,
    val disabledStrokeColor: Color,

    val text: Color,
    val pressedText: Color,
    val disabledText: Color
)
