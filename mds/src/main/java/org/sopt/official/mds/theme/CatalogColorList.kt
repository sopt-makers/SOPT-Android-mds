package org.sopt.official.mds.theme

import androidx.compose.ui.graphics.Color
import org.sopt.official.mds.foundation.base.blue100
import org.sopt.official.mds.foundation.base.blue200
import org.sopt.official.mds.foundation.base.blue300
import org.sopt.official.mds.foundation.base.blue400
import org.sopt.official.mds.foundation.base.blue50
import org.sopt.official.mds.foundation.base.blue500
import org.sopt.official.mds.foundation.base.blue600
import org.sopt.official.mds.foundation.base.blue700
import org.sopt.official.mds.foundation.base.blue800
import org.sopt.official.mds.foundation.base.blue900
import org.sopt.official.mds.foundation.base.blue950
import org.sopt.official.mds.foundation.base.gray0
import org.sopt.official.mds.foundation.base.gray10
import org.sopt.official.mds.foundation.base.gray100
import org.sopt.official.mds.foundation.base.gray20
import org.sopt.official.mds.foundation.base.gray200
import org.sopt.official.mds.foundation.base.gray30
import org.sopt.official.mds.foundation.base.gray300
import org.sopt.official.mds.foundation.base.gray400
import org.sopt.official.mds.foundation.base.gray50
import org.sopt.official.mds.foundation.base.gray500
import org.sopt.official.mds.foundation.base.gray600
import org.sopt.official.mds.foundation.base.gray700
import org.sopt.official.mds.foundation.base.gray800
import org.sopt.official.mds.foundation.base.gray900
import org.sopt.official.mds.foundation.base.gray950
import org.sopt.official.mds.foundation.base.green100
import org.sopt.official.mds.foundation.base.green200
import org.sopt.official.mds.foundation.base.green300
import org.sopt.official.mds.foundation.base.green400
import org.sopt.official.mds.foundation.base.green50
import org.sopt.official.mds.foundation.base.green500
import org.sopt.official.mds.foundation.base.green600
import org.sopt.official.mds.foundation.base.green700
import org.sopt.official.mds.foundation.base.green800
import org.sopt.official.mds.foundation.base.green900
import org.sopt.official.mds.foundation.base.green950
import org.sopt.official.mds.foundation.base.orange100
import org.sopt.official.mds.foundation.base.orange200
import org.sopt.official.mds.foundation.base.orange300
import org.sopt.official.mds.foundation.base.orange400
import org.sopt.official.mds.foundation.base.orange50
import org.sopt.official.mds.foundation.base.orange500
import org.sopt.official.mds.foundation.base.orange600
import org.sopt.official.mds.foundation.base.orange700
import org.sopt.official.mds.foundation.base.orange800
import org.sopt.official.mds.foundation.base.orange900
import org.sopt.official.mds.foundation.base.orange950
import org.sopt.official.mds.foundation.base.red100
import org.sopt.official.mds.foundation.base.red200
import org.sopt.official.mds.foundation.base.red300
import org.sopt.official.mds.foundation.base.red400
import org.sopt.official.mds.foundation.base.red50
import org.sopt.official.mds.foundation.base.red500
import org.sopt.official.mds.foundation.base.red600
import org.sopt.official.mds.foundation.base.red700
import org.sopt.official.mds.foundation.base.red800
import org.sopt.official.mds.foundation.base.red900
import org.sopt.official.mds.foundation.base.red950
import org.sopt.official.mds.foundation.base.yellow100
import org.sopt.official.mds.foundation.base.yellow200
import org.sopt.official.mds.foundation.base.yellow300
import org.sopt.official.mds.foundation.base.yellow400
import org.sopt.official.mds.foundation.base.yellow50
import org.sopt.official.mds.foundation.base.yellow500
import org.sopt.official.mds.foundation.base.yellow600
import org.sopt.official.mds.foundation.base.yellow700
import org.sopt.official.mds.foundation.base.yellow800
import org.sopt.official.mds.foundation.base.yellow900
import org.sopt.official.mds.foundation.base.yellow950

data class ColorToken(
    val name: String,
    val color: Color
)

val grayTokens = listOf(
    ColorToken("gray0", gray0),
    ColorToken("gray10", gray10),
    ColorToken("gray20", gray20),
    ColorToken("gray30", gray30),
    ColorToken("gray50", gray50),
    ColorToken("gray100", gray100),
    ColorToken("gray200", gray200),
    ColorToken("gray300", gray300),
    ColorToken("gray400", gray400),
    ColorToken("gray500", gray500),
    ColorToken("gray600", gray600),
    ColorToken("gray700", gray700),
    ColorToken("gray800", gray800),
    ColorToken("gray900", gray900),
    ColorToken("gray950", gray950),
)

val orangeTokens = listOf(
    ColorToken("orange50", orange50),
    ColorToken("orange100", orange100),
    ColorToken("orange200", orange200),
    ColorToken("orange300", orange300),
    ColorToken("orange400", orange400),
    ColorToken("orange500", orange500),
    ColorToken("orange600", orange600),
    ColorToken("orange700", orange700),
    ColorToken("orange800", orange800),
    ColorToken("orange900", orange900),
    ColorToken("orange950", orange950),
)

val blueTokens = listOf(
    ColorToken("blue50", blue50),
    ColorToken("blue100", blue100),
    ColorToken("blue200", blue200),
    ColorToken("blue300", blue300),
    ColorToken("blue400", blue400),
    ColorToken("blue500", blue500),
    ColorToken("blue600", blue600),
    ColorToken("blue700", blue700),
    ColorToken("blue800", blue800),
    ColorToken("blue900", blue900),
    ColorToken("blue950", blue950),
)

val redTokens = listOf(
    ColorToken("red50", red50),
    ColorToken("red100", red100),
    ColorToken("red200", red200),
    ColorToken("red300", red300),
    ColorToken("red400", red400),
    ColorToken("red500", red500),
    ColorToken("red600", red600),
    ColorToken("red700", red700),
    ColorToken("red800", red800),
    ColorToken("red900", red900),
    ColorToken("red950", red950),
)

val greenTokens = listOf(
    ColorToken("green50", green50),
    ColorToken("green100", green100),
    ColorToken("green200", green200),
    ColorToken("green300", green300),
    ColorToken("green400", green400),
    ColorToken("green500", green500),
    ColorToken("green600", green600),
    ColorToken("green700", green700),
    ColorToken("green800", green800),
    ColorToken("green900", green900),
    ColorToken("green950", green950),
)

val yellowTokens = listOf(
    ColorToken("yellow50", yellow50),
    ColorToken("yellow100", yellow100),
    ColorToken("yellow200", yellow200),
    ColorToken("yellow300", yellow300),
    ColorToken("yellow400", yellow400),
    ColorToken("yellow500", yellow500),
    ColorToken("yellow600", yellow600),
    ColorToken("yellow700", yellow700),
    ColorToken("yellow800", yellow800),
    ColorToken("yellow900", yellow900),
    ColorToken("yellow950", yellow950),
)