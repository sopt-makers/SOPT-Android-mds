package org.sopt.official.mds.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.R
import org.sopt.official.mds.theme.SoptTheme

@Composable
fun MdsTextArea(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    inputType: MdsInputType = MdsInputType.DEFAULT,
    inputLimits: TextFieldLineLimits = TextFieldLineLimits.MultiLine(),
    required: Boolean = false,
    label: String? = null,
    description: String? = null,
    placeholder: String? = null,
    helperText: String? = null,
    errorText: String? = null,
    maxLength: Int? = null,
    isError: Boolean = false,
    showActionIcon: Boolean = false,
    onKeyboardAction: KeyboardActionHandler? = null,
    inputTransformation: InputTransformation? = null
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
    ) {
        if (required || !label.isNullOrBlank()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                label?.let {
                    Text(
                        text = label,
                        style = SoptTheme.typography.title5,
                        color = SoptTheme.colors.fg.neutral.bold
                    )
                }

                if (required) {
                    Text(
                        text = "*",
                        style = SoptTheme.typography.title5,
                        color = SoptTheme.colors.fg.brand.default
                    )
                }
            }
        }

        description?.let {
            Text(
                text = description,
                style = SoptTheme.typography.body2,
                color = SoptTheme.colors.fg.neutral.default
            )
        }

        Spacer(Modifier.height(10.dp))

        MdsBasicTextField(
            state = state,
            textStyle = SoptTheme.typography.body1.copy(
                color = SoptTheme.colors.fg.neutral.bold
            ),
            interactionSource = interactionSource,
            decorator = { innerTextField ->
                MdsTextAreaDecorator(
                    state = state,
                    interactionSource = interactionSource,
                    inputType = inputType,
                    placeholder = placeholder,
                    innerTextField = innerTextField,
                    showActionIcon = showActionIcon,
                    isError = isError
                )
            },
            lineLimits = inputLimits,
            onKeyboardAction = onKeyboardAction,
            inputTransformation = inputTransformation
        )

        MdsTextAreaFooter(
            helperText = helperText,
            errorText = errorText,
            isError = isError,
            maxLength = maxLength,
            currentLength = state.text.length
        )
    }
}

@Composable
private fun MdsTextAreaDecorator(
    state: TextFieldState,
    interactionSource: MutableInteractionSource,
    inputType: MdsInputType,
    placeholder: String?,
    isError: Boolean,
    showActionIcon: Boolean,
    innerTextField: @Composable () -> Unit
) {
    val focused by interactionSource.collectIsFocusedAsState()

    val strokeColor = when {
        isError -> SoptTheme.colors.stroke.danger.default
        focused -> SoptTheme.colors.stroke.neutral.defaultFocused
        else -> Color.Transparent
    }

    MdsBasicDecorator(
        state = state,
        modifier = Modifier
            .heightIn(max = 150.dp)
            .border(
                1.dp,
                strokeColor,
                RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(
                when (inputType) {
                    MdsInputType.DEFAULT -> SoptTheme.colors.bg.layer.default
                    MdsInputType.BOLD -> SoptTheme.colors.bg.neutral.ghost
                }
            )
            .padding(horizontal = 14.dp, vertical = 10.dp),
        placeholder = {
            placeholder?.let {
                Text(
                    text = placeholder,
                    style = SoptTheme.typography.body1,
                    color = SoptTheme.colors.fg.neutral.ghost
                )
            }
        },
        trailingIcon = {
            if (showActionIcon) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_send_outlined),
                    contentDescription = null,
                    tint = SoptTheme.colors.fg.neutral.bold,
                    modifier = Modifier
                        .padding(start = 14.dp)
                        .size(20.dp)
                )
            }
        },
        innerTextField = innerTextField
    )
}

@Composable
private fun MdsTextAreaFooter(
    helperText: String? = null,
    errorText: String? = null,
    isError: Boolean = false,
    maxLength: Int? = null,
    currentLength: Int? = null
) {
    if (helperText.isNullOrBlank() && errorText.isNullOrBlank() && maxLength == null) return

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isError && !errorText.isNullOrBlank()) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_info_circle_outlined),
                contentDescription = null,
                tint = SoptTheme.colors.fg.danger.default,
                modifier = Modifier.size(14.dp)
            )

            Spacer(Modifier.width(4.dp))
        }

        Text(
            text = (if (isError) errorText else helperText) ?: "",
            style = SoptTheme.typography.body3,
            color = if (isError) SoptTheme.colors.fg.danger.default else SoptTheme.colors.fg.neutral.ghost,
            modifier = Modifier.weight(1f)
        )

        maxLength?.let {
            Text(
                text = "$currentLength/$maxLength",
                style = SoptTheme.typography.body3,
                color = SoptTheme.colors.fg.neutral.ghost
            )
        }
    }
}
