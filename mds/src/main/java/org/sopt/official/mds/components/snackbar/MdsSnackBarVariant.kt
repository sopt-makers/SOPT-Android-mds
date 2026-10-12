package org.sopt.official.mds.components.snackbar

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.sopt.official.mds.MdsIcons
import org.sopt.official.mds.theme.SoptTheme

enum class MdsSnackBarVariant(
    @param:DrawableRes val icon: Int,
) {
    SUCCESS(MdsIcons.checkCircleFilled),
    ALERT(MdsIcons.alertCircleFilled),
    ERROR(MdsIcons.alertCircleFilled);

    @Composable
    internal fun iconColor(): Color =
        when (this) {
            SUCCESS -> SoptTheme.colors.fg.success.default
            ALERT -> SoptTheme.colors.fg.attention.default
            ERROR -> SoptTheme.colors.fg.danger.default
        }
}
