package org.sopt.official.mds.components.callout

import androidx.compose.runtime.Composable
import org.sopt.official.mds.theme.SoptTheme

enum class MdsCalloutType {
    DANGER,
    INFORMATION;

    @Composable
    internal fun colors(): MdsCalloutColors =
        when (this) {
            DANGER -> MdsCalloutColors(
                background = SoptTheme.colors.bg.danger.ghost,
                border = SoptTheme.colors.stroke.danger.default,
                text = SoptTheme.colors.fg.neutral.bold,
                icon = SoptTheme.colors.fg.danger.default
            )

            INFORMATION -> MdsCalloutColors(
                background = SoptTheme.colors.bg.information.ghost,
                border = SoptTheme.colors.stroke.information.subtle,
                text = SoptTheme.colors.fg.neutral.bold,
                icon = SoptTheme.colors.fg.information.default
            )
        }
}
