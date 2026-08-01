package org.sopt.official.mds.components.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import org.sopt.official.mds.components.button.MdsActionButton
import org.sopt.official.mds.components.button.MdsActionButtonSize
import org.sopt.official.mds.components.button.MdsActionButtonType
import org.sopt.official.mds.components.control.checkbox.MdsCheckbox
import org.sopt.official.mds.theme.SoptTheme

@Composable
internal fun MdsOneButtonDialog(
    title: String,
    buttonText: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    properties: DialogProperties = DialogProperties(
        usePlatformDefaultWidth = false
    ),
    checkboxEnabled: Boolean = false,
    checkboxText: String = "",
    checkboxSelected: Boolean = false,
    onCheckboxClick: (Boolean) -> Unit = {},
    onDismiss: () -> Unit = {},
    onButtonClick: () -> Unit,
) {
    MdsBasicDialog(
        onDismiss = onDismiss,
        modifier = modifier,
        properties = properties
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = title,
                style = SoptTheme.typography.heading3,
                color = SoptTheme.colors.fg.neutral.bold,
                modifier = Modifier.fillMaxWidth()
            )

            description?.let {
                Spacer(Modifier.height(8.dp))

                Text(
                    text = description,
                    style = SoptTheme.typography.body2,
                    color = SoptTheme.colors.fg.neutral.default,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            if (checkboxEnabled) {
                Spacer(Modifier.height(24.dp))

                MdsCheckbox(
                    text = checkboxText,
                    selected = checkboxSelected,
                    enabled = true,
                    onClick = onCheckboxClick
                )
            }

            Spacer(Modifier.height(20.dp))

            MdsActionButton(
                text = buttonText,
                type = MdsActionButtonType.PRIMARY,
                size = MdsActionButtonSize.MEDIUM,
                onClick = onButtonClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
