package org.sopt.official.mds.components.input

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import org.sopt.official.mds.theme.SoptTheme

@Composable
internal fun MdsBasicTextField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    interactionSource: MutableInteractionSource? = null,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onKeyboardAction: KeyboardActionHandler? = null,
    decorator: TextFieldDecorator? = null,
) {
    BasicTextField(
        state = state,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        lineLimits = lineLimits,
        cursorBrush = SolidColor(SoptTheme.colors.fg.neutral.bold),
        interactionSource = interactionSource,
        inputTransformation = inputTransformation,
        outputTransformation = outputTransformation,
        keyboardOptions = keyboardOptions,
        onKeyboardAction = onKeyboardAction,
        decorator = decorator,
    )
}
