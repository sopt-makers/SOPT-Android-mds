package org.sopt.official.mds.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import org.sopt.official.mds.foundation.semantic.MdsColors

object SoptTheme {
    val colors: MdsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSoptColors.current
}

private val LocalSoptColors = staticCompositionLocalOf<MdsColors> {
    error("No SoptColors provided")
}

@Composable
fun ProvideSoptColorsAndTypography(
    colors: MdsColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSoptColors provides colors,
        content = content
    )
}

@Composable
fun SoptTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    val colors = DarkMdsColorScheme
    ProvideSoptColorsAndTypography(colors) {
        MaterialTheme(content = content)
    }
}
