package org.sopt.official.mds.theme

import org.sopt.official.mds.foundation.base.blue400
import org.sopt.official.mds.foundation.base.blue500
import org.sopt.official.mds.foundation.base.blue600
import org.sopt.official.mds.foundation.base.blue900
import org.sopt.official.mds.foundation.base.blue950
import org.sopt.official.mds.foundation.base.gray10
import org.sopt.official.mds.foundation.base.gray100
import org.sopt.official.mds.foundation.base.gray200
import org.sopt.official.mds.foundation.base.gray300
import org.sopt.official.mds.foundation.base.gray500
import org.sopt.official.mds.foundation.base.gray600
import org.sopt.official.mds.foundation.base.gray700
import org.sopt.official.mds.foundation.base.gray800
import org.sopt.official.mds.foundation.base.gray900
import org.sopt.official.mds.foundation.base.gray950
import org.sopt.official.mds.foundation.base.green100
import org.sopt.official.mds.foundation.base.green400
import org.sopt.official.mds.foundation.base.green600
import org.sopt.official.mds.foundation.base.green950
import org.sopt.official.mds.foundation.base.orange400
import org.sopt.official.mds.foundation.base.orange600
import org.sopt.official.mds.foundation.base.orange700
import org.sopt.official.mds.foundation.base.orange950
import org.sopt.official.mds.foundation.base.red100
import org.sopt.official.mds.foundation.base.red400
import org.sopt.official.mds.foundation.base.red500
import org.sopt.official.mds.foundation.base.red600
import org.sopt.official.mds.foundation.base.red950
import org.sopt.official.mds.foundation.base.yellow200
import org.sopt.official.mds.foundation.base.yellow400
import org.sopt.official.mds.foundation.base.yellow600
import org.sopt.official.mds.foundation.semantic.MdsBgColors
import org.sopt.official.mds.foundation.semantic.MdsColors
import org.sopt.official.mds.foundation.semantic.MdsFgColors
import org.sopt.official.mds.foundation.semantic.MdsStrokeColors

val DarkMdsColorScheme = MdsColors(
    bg = MdsBgColors(
        neutral = MdsBgColors.Neutral(
            inverse = gray10,
            inverseHover = gray100,
            inversePressed = gray100,
            bold = gray500,
            boldDisabled = gray700,
            default = gray600,
            defaultHover = gray500,
            defaultPressed = gray500,
            defaultDisabled = gray800,
            subtle = gray700,
            subtleHover = gray600,
            subtlePressed = gray600,
            ghost = gray800,
            ghostHover = gray700,
            ghostPressed = gray700
        ),
        brand = MdsBgColors.Brand(
            default = orange400,
            subtle = orange700,
            ghost = orange950
        ),
        secondary = MdsBgColors.Secondary(
            default = blue400,
            defaultHover = blue500,
            defaultPressed = blue600,
            subtle = blue900,
            ghost = blue950
        ),
        information = MdsBgColors.Information(ghost = blue950),
        success = MdsBgColors.Success(ghost = green950),
        danger = MdsBgColors.Danger(
            default = red400,
            defaultHover = red500,
            defaultPressed = red600,
            ghost = red950
        ),
        dim = MdsBgColors.Dim(default = gray950.copy(alpha = 0.8f)),
        layer = MdsBgColors.Layer(
            basement = gray950,
            basementHover = gray800,
            default = gray900,
            defaultHover = gray800
        )
    ),
    fg = MdsFgColors(
        neutral = MdsFgColors.Neutral(
            bold = gray10,
            default = gray100,
            defaultDisabled = gray500,
            subtle = gray300,
            ghost = gray500,
            ghostDisabled = gray700,
            inverse = gray950
        ),
        brand = MdsFgColors.Brand(default = orange400),
        secondary = MdsFgColors.Secondary(default = blue400),
        success = MdsFgColors.Success(
            bold = green100,
            default = green400,
            subtle = green600
        ),
        danger = MdsFgColors.Danger(
            bold = red100,
            default = red400,
            subtle = red600
        ),
        attention = MdsFgColors.Attention(
            bold = yellow200,
            default = yellow400,
            subtle = yellow600
        ),
        information = MdsFgColors.Information(
            default = blue400,
            subtle = blue600
        )
    ),
    stroke = MdsStrokeColors(
        neutral = MdsStrokeColors.Neutral(
            default = gray600,
            defaultFocused = gray200,
            defaultDisabled = gray700,
            inverse = gray10,
            subtle = gray700,
            ghost = gray800
        ),
        brand = MdsStrokeColors.Brand(
            default = orange400,
            subtle = orange600
        ),
        secondary = MdsStrokeColors.Secondary(
            default = blue400,
            subtle = blue600
        ),
        information = MdsStrokeColors.Information(subtle = blue600),
        danger = MdsStrokeColors.Danger(default = red400)
    ),
    isLight = false
)
