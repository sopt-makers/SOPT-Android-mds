package org.sopt.official.mds.components.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun MdsBasicDecorator(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    innerTextField: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        leadingIcon?.invoke()

        Box(
            modifier = Modifier.weight(1f)
        ) {

            if (state.text.isEmpty()) {
                placeholder?.invoke()
            }

            innerTextField()
        }

        trailingIcon?.invoke()
    }
}
