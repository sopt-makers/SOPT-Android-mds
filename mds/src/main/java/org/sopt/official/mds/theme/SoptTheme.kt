package org.sopt.official.mds.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import org.sopt.official.mds.foundation.semantic.MdsColors
import org.sopt.official.mds.foundation.semantic.MdsTypography

object SoptTheme {
    val colors: MdsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSoptColors.current

    val typography: MdsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSoptTypography.current
}

private val LocalSoptColors = staticCompositionLocalOf<MdsColors> {
    error("No SoptColors provided")
}

private val LocalSoptTypography = staticCompositionLocalOf<MdsTypography> {
    error("No SoptTypography provided")
}

@Composable
fun ProvideSoptColorsAndTypography(
    colors: MdsColors,
    typography: MdsTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSoptColors provides colors,
        LocalSoptTypography provides typography,
        content = content
    )
}

@Composable
fun SoptTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    val colors = DarkMdsColorScheme
    val typography = MdsTypographyScheme
    ProvideSoptColorsAndTypography(colors, typography) {
        MaterialTheme(content = content)
    }
}
