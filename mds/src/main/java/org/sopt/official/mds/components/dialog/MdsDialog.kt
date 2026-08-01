package org.sopt.official.mds.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import org.sopt.official.mds.components.button.MdsActionButtonType

@Composable
fun MdsDialog(
    title: String,
    onDismiss: () -> Unit,
    positiveButtonText: String,
    description: String? = null,
    properties: DialogProperties = DialogProperties(
        usePlatformDefaultWidth = false
    ),
    checkboxEnabled: Boolean = false,
    checkboxText: String = "",
    checkboxSelected: Boolean = false,
    onCheckboxClick: (Boolean) -> Unit = {},
    type: MdsDialogType = MdsDialogType.DEFAULT,
    negativeButtonText: String = "",
    onNegativeButtonClick: () -> Unit = {},
    onPositiveButtonClick: () -> Unit
) {
    when (type) {
        MdsDialogType.DEFAULT -> MdsTwoButtonDialog(
            title = title,
            description = description,
            onDismiss = onDismiss,
            positiveButtonText = positiveButtonText,
            negativeButtonText = negativeButtonText,
            onPositiveClick = onPositiveButtonClick,
            onNegativeClick = onNegativeButtonClick,
            positiveButtonType = MdsActionButtonType.PRIMARY,
            checkboxEnabled = checkboxEnabled,
            checkboxText = checkboxText,
            checkboxSelected = checkboxSelected,
            onCheckboxClick = onCheckboxClick
        )

        MdsDialogType.INFORMATION -> MdsOneButtonDialog(
            title = title,
            description = description,
            buttonText = positiveButtonText,
            onDismiss = onDismiss,
            onButtonClick = onPositiveButtonClick,
            checkboxEnabled = checkboxEnabled,
            checkboxText = checkboxText,
            checkboxSelected = checkboxSelected,
            onCheckboxClick = onCheckboxClick
        )

        MdsDialogType.DANGER -> MdsTwoButtonDialog(
            title = title,
            description = description,
            onDismiss = onDismiss,
            positiveButtonText = positiveButtonText,
            negativeButtonText = negativeButtonText,
            onPositiveClick = onPositiveButtonClick,
            onNegativeClick = onNegativeButtonClick,
            positiveButtonType = MdsActionButtonType.DANGER,
            checkboxEnabled = checkboxEnabled,
            checkboxText = checkboxText,
            checkboxSelected = checkboxSelected,
            onCheckboxClick = onCheckboxClick
        )
    }
}
