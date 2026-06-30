package org.sopt.official.mds.foundation.semantic

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class MdsTypography(
    val heading: Heading,
    val title: Title,
    val body: Body,
    val label: Label
) {
    data class Heading(val h1: TextStyle, val h2: TextStyle, val h3: TextStyle, val h4: TextStyle)
    data class Title(val t1: TextStyle, val t2: TextStyle, val t3: TextStyle, val t4: TextStyle, val t5: TextStyle)
    data class Body(val b1: TextStyle, val b2: TextStyle)
    data class Label(val l1: TextStyle, val l2: TextStyle, val l3: TextStyle, val l4: TextStyle)
}
