package org.sopt.official.mds.foundation.base

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.official.mds.R

val MdsFontFamily = FontFamily(
    Font(R.font.suit_bold, FontWeight.Bold),
    Font(R.font.suit_semibold, FontWeight.SemiBold),
    Font(R.font.suit_regular, FontWeight.Normal)
)

internal object MdsBaseTypography {
    // Font Size
    val size32 = 32.sp
    val size28 = 28.sp
    val size24 = 24.sp
    val size20 = 20.sp
    val size18 = 18.sp
    val size16 = 16.sp
    val size14 = 14.sp
    val size12 = 12.sp

    // Line Height
    val line48 = 48.sp
    val line42 = 42.sp
    val line36 = 36.sp
    val line30 = 30.sp
    val line26 = 26.sp
    val line24 = 24.sp
    val line22 = 22.sp
    val line18 = 18.sp
    val line16 = 16.sp

    // Letter Spacing
    val spacingDefault = (-0.02).em
    val spacingWide = (-0.015).em
}