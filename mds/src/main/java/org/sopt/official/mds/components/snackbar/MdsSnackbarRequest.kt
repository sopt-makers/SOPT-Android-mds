package org.sopt.official.mds.components.snackbar

import androidx.compose.runtime.Immutable

@Immutable
data class MdsSnackbarRequest(
    val message: String,
    val variant: MdsSnackBarVariant = MdsSnackBarVariant.SUCCESS,
    val showIcon: Boolean = false,
    val buttonText: String = "보러가기",
    val onButtonClick: (() -> Unit)? = null
)
