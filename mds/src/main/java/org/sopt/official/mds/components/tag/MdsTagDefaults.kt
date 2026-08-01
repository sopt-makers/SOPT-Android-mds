package org.sopt.official.mds.components.tag

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import org.sopt.official.mds.foundation.base.size12
import org.sopt.official.mds.foundation.base.size14
import org.sopt.official.mds.theme.SoptTheme

object MdsTagDefaults {

    @Composable
    internal fun colors(
        type: MdsTagType,
        emphasis: MdsTagEmphasis
    ): MdsTagColors {
        return when (type) {
            MdsTagType.DEFAULT -> {
                when (emphasis) {
                    MdsTagEmphasis.SOLID -> MdsTagColors(
                        backgroundColor = SoptTheme.colors.bg.neutral.subtle,
                        textColor = SoptTheme.colors.fg.neutral.bold
                    )

                    MdsTagEmphasis.SUBTLE -> MdsTagColors(
                        backgroundColor = SoptTheme.colors.bg.neutral.subtle,
                        textColor = SoptTheme.colors.fg.neutral.subtle
                    )
                }
            }

            MdsTagType.PRIMARY -> {
                when (emphasis) {
                    MdsTagEmphasis.SOLID -> MdsTagColors(
                        backgroundColor = SoptTheme.colors.bg.brand.default,
                        textColor = SoptTheme.colors.fg.neutral.inverse
                    )

                    MdsTagEmphasis.SUBTLE -> MdsTagColors(
                        backgroundColor = SoptTheme.colors.bg.brand.ghost,
                        textColor = SoptTheme.colors.fg.brand.default
                    )
                }
            }

            MdsTagType.SECONDARY -> {
                when (emphasis) {
                    MdsTagEmphasis.SOLID -> MdsTagColors(
                        backgroundColor = SoptTheme.colors.bg.secondary.default,
                        textColor = SoptTheme.colors.fg.neutral.bold
                    )

                    MdsTagEmphasis.SUBTLE -> MdsTagColors(
                        backgroundColor = SoptTheme.colors.bg.secondary.subtle,
                        textColor = SoptTheme.colors.fg.secondary.default
                    )
                }
            }
        }
    }

}

enum class MdsTagSize(
    val iconSize: Dp
) {
    SMALL(size12),
    MEDIUM(size14);

    @Composable
    internal fun typography(): TextStyle {
        return when (this) {
            SMALL -> SoptTheme.typography.label4
            MEDIUM -> SoptTheme.typography.label3
        }
    }
}

enum class MdsTagShape(
    val shape: Shape
) {
    RECT(RoundedCornerShape(SoptTheme.radius.r4)),
    PILL(RoundedCornerShape(SoptTheme.radius.full))
}

enum class MdsTagType {
    DEFAULT,
    PRIMARY,
    SECONDARY
}

enum class MdsTagEmphasis {
    SOLID,
    SUBTLE,
}

@Immutable
internal data class MdsTagColors(
    val backgroundColor: Color,
    val textColor: Color
)
