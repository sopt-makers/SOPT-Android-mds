package org.sopt.official.mds.foundation.semantic

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
class MdsColors(
    val bg: MdsBgColors,
    val fg: MdsFgColors,
    val stroke: MdsStrokeColors,
    val isLight: Boolean
)

@Immutable
data class MdsBgColors(
    val neutral: Neutral,
    val brand: Brand,
    val secondary: Secondary,
    val danger: Danger,
    val success: Success,
    val information: Information,
    val dim: Dim
) {
    data class Neutral(
        val inverse: Color, val inverseHover: Color, val inversePressed: Color,
        val bold: Color, val boldDisabled: Color,
        val default: Color, val defaultHover: Color, val defaultPressed: Color, val defaultDisabled: Color,
        val subtle: Color, val subtleHover: Color, val subtlePressed: Color,
        val ghost: Color, val ghostHover: Color, val ghostPressed: Color
    )
    data class Brand(val default: Color, val subtle: Color, val ghost: Color)
    data class Secondary(val default: Color, val defaultHover: Color, val defaultPressed: Color, val subtle: Color, val ghost: Color)
    data class Danger(val default: Color, val defaultHover: Color, val defaultPressed: Color, val ghost: Color)
    data class Success(val ghost: Color)
    data class Information(val ghost: Color)
    data class Dim(val default: Color)
}

@Immutable
data class MdsFgColors(
    val neutral: Neutral,
    val brand: Brand,
    val secondary: Secondary,
    val success: Success,
    val danger: Danger,
    val attention: Attention,
    val information: Information
) {
    data class Neutral(
        val bold: Color, val default: Color, val defaultDisabled: Color,
        val subtle: Color, val ghost: Color, val inverse: Color
    )
    data class Brand(val default: Color)
    data class Secondary(val default: Color)
    data class Success(val bold: Color, val default: Color, val subtle: Color)
    data class Danger(val bold: Color, val default: Color, val subtle: Color)
    data class Attention(val bold: Color, val default: Color, val subtle: Color)
    data class Information(val default: Color, val subtle: Color)
}

@Immutable
data class MdsStrokeColors(
    val neutral: Neutral,
    val brand: Brand,
    val secondary: Secondary,
    val information: Information,
    val danger: Danger
) {
    data class Neutral(
        val default: Color, val defaultFocused: Color, val defaultDisabled: Color,
        val inverse: Color, val subtle: Color, val ghost: Color
    )
    data class Brand(val default: Color, val subtle: Color)
    data class Secondary(val default: Color, val subtle: Color)
    data class Information(val subtle: Color)
    data class Danger(val default: Color)
}