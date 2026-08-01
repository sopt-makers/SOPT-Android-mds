package org.sopt.official.mds.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import org.sopt.official.mds.foundation.base.MdsBaseTypography
import org.sopt.official.mds.foundation.base.MdsFontFamily
import org.sopt.official.mds.foundation.semantic.MdsTypography

private val MdsLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

private fun mdsTextStyle(
    fontWeight: FontWeight,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit
) = TextStyle(
    fontFamily = MdsFontFamily,
    fontWeight = fontWeight,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = MdsLineHeightStyle
)

internal val MdsTypographyScheme = MdsTypography(
    heading1 = mdsTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = MdsBaseTypography.size32,
        lineHeight = MdsBaseTypography.line48,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    heading2 = mdsTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = MdsBaseTypography.size24,
        lineHeight = MdsBaseTypography.line36,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    heading3 = mdsTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = MdsBaseTypography.size20,
        lineHeight = MdsBaseTypography.line30,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    heading4 = mdsTextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = MdsBaseTypography.size16,
        lineHeight = MdsBaseTypography.line24,
        letterSpacing = MdsBaseTypography.spacingWide
    ),

    title1 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size28,
        lineHeight = MdsBaseTypography.line42,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    title2 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size24,
        lineHeight = MdsBaseTypography.line36,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    title3 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size20,
        lineHeight = MdsBaseTypography.line30,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    title4 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size18,
        lineHeight = MdsBaseTypography.line26,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    title5 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size16,
        lineHeight = MdsBaseTypography.line24,
        letterSpacing = MdsBaseTypography.spacingWide
    ),

    body1 = mdsTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = MdsBaseTypography.size16,
        lineHeight = MdsBaseTypography.line26,
        letterSpacing = MdsBaseTypography.spacingWide
    ),
    body2 = mdsTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = MdsBaseTypography.size14,
        lineHeight = MdsBaseTypography.line22,
        letterSpacing = MdsBaseTypography.spacingWide
    ),
    body3 = mdsTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = MdsBaseTypography.size12,
        lineHeight = MdsBaseTypography.line18,
        letterSpacing = MdsBaseTypography.spacingWide
    ),

    label1 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size18,
        lineHeight = MdsBaseTypography.line24,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    label2 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size16,
        lineHeight = MdsBaseTypography.line22,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    label3 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size14,
        lineHeight = MdsBaseTypography.line18,
        letterSpacing = MdsBaseTypography.spacingDefault
    ),
    label4 = mdsTextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = MdsBaseTypography.size12,
        lineHeight = MdsBaseTypography.line16,
        letterSpacing = MdsBaseTypography.spacingDefault
    )
)
