package org.sopt.official.mds.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.R
import org.sopt.official.mds.theme.SoptTheme

@Composable
fun MdsSearchField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    inputType: MdsInputType = MdsInputType.DEFAULT,
    placeholder: String? = null,
    onSearch: (String) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    MdsBasicTextField(
        state = state,
        modifier = modifier,
        textStyle = SoptTheme.typography.body1.copy(
            color = SoptTheme.colors.fg.neutral.bold
        ),
        lineLimits = TextFieldLineLimits.SingleLine,
        interactionSource = interactionSource,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        onKeyboardAction = {
            onSearch(state.text.toString())
        },
        decorator = { innerTextField ->
            MdsSearchFieldDecorator(
                state = state,
                interactionSource = interactionSource,
                inputType = inputType,
                placeholder = placeholder,
                innerTextField = innerTextField
            )
        }
    )
}

@Composable
private fun MdsSearchFieldDecorator(
    state: TextFieldState,
    interactionSource: MutableInteractionSource,
    inputType: MdsInputType,
    placeholder: String? = null,
    innerTextField: @Composable () -> Unit
) {
    val focused by interactionSource.collectIsFocusedAsState()

    val modifierWithBorder = Modifier.border(
        1.dp,
        SoptTheme.colors.stroke.neutral.defaultFocused,
        RoundedCornerShape(10.dp)
    )

    MdsBasicDecorator(
        state = state,
        modifier = Modifier
            .then(
                if (focused) modifierWithBorder else Modifier
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
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_search_outlined),
                contentDescription = null,
                tint = SoptTheme.colors.fg.neutral.default,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(20.dp)
            )
        },
        trailingIcon = {
            if (focused) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_x_circle_filled),
                    contentDescription = null,
                    tint = SoptTheme.colors.fg.neutral.bold,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(20.dp)
                        .clickable(onClick = state::clearText)
                )
            }
        },
        innerTextField = innerTextField
    )
}
