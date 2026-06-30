package org.sopt.official.mds.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import org.sopt.official.mds.foundation.base.MdsBaseTypography
import org.sopt.official.mds.foundation.base.MdsFontFamily
import org.sopt.official.mds.foundation.semantic.MdsTypography

val MdsTypographyScheme = MdsTypography(
    heading = MdsTypography.Heading(
        h1 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = MdsBaseTypography.size32,
            lineHeight = MdsBaseTypography.line48,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        h2 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = MdsBaseTypography.size24,
            lineHeight = MdsBaseTypography.line36,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        h3 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = MdsBaseTypography.size20,
            lineHeight = MdsBaseTypography.line30,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        h4 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = MdsBaseTypography.size16,
            lineHeight = MdsBaseTypography.line24,
            letterSpacing = MdsBaseTypography.spacingWide
        )
    ),
    title = MdsTypography.Title(
        t1 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size28,
            lineHeight = MdsBaseTypography.line42,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        t2 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size24,
            lineHeight = MdsBaseTypography.line36,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        t3 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size20,
            lineHeight = MdsBaseTypography.line30,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        t4 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size18,
            lineHeight = MdsBaseTypography.line26,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        t5 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size16,
            lineHeight = MdsBaseTypography.line24,
            letterSpacing = MdsBaseTypography.spacingWide
        )
    ),
    body = MdsTypography.Body(
        b1 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = MdsBaseTypography.size16,
            lineHeight = MdsBaseTypography.line26,
            letterSpacing = MdsBaseTypography.spacingWide
        ),
        b2 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = MdsBaseTypography.size14,
            lineHeight = MdsBaseTypography.line22,
            letterSpacing = MdsBaseTypography.spacingWide
        )
    ),
    label = MdsTypography.Label(
        l1 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size18,
            lineHeight = MdsBaseTypography.line24,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        l2 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size16,
            lineHeight = MdsBaseTypography.line22,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        l3 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size14,
            lineHeight = MdsBaseTypography.line18,
            letterSpacing = MdsBaseTypography.spacingDefault
        ),
        l4 = TextStyle(
            fontFamily = MdsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = MdsBaseTypography.size12,
            lineHeight = MdsBaseTypography.line16,
            letterSpacing = MdsBaseTypography.spacingDefault
        )
    )
)
