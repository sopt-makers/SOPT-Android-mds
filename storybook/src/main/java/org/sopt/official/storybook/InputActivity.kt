package org.sopt.official.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.components.control.toggle.MdsToggle
import org.sopt.official.mds.components.control.toggle.MdsToggleSize
import org.sopt.official.mds.components.input.MdsInputType
import org.sopt.official.mds.components.input.MdsSearchField
import org.sopt.official.mds.components.input.MdsTextArea
import org.sopt.official.mds.components.input.MdsTextField
import org.sopt.official.mds.theme.SoptTheme

class InputActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoptTheme() {
                Scaffold(
                    containerColor = SoptTheme.colors.bg.layer.basement,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    val focusManager = LocalFocusManager.current

                    Column(
                        modifier = Modifier
                            .padding(it)
                            .padding(10.dp)
                            .verticalScroll(rememberScrollState())
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = { focusManager.clearFocus() }
                            ),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Text(
                            text = "Input",
                            style = SoptTheme.typography.title1,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )

                        Text(
                            text = "Search Field",
                            style = SoptTheme.typography.title2,
                            color = SoptTheme.colors.fg.neutral.default
                        )

                        var searchText by remember { mutableStateOf(TextFieldState()) }



                        MdsSearchField(
                            searchText,
                            placeholder = "Default search field",
                            inputType = MdsInputType.DEFAULT
                        ) {

                        }

                        MdsSearchField(
                            searchText,
                            placeholder = "Bold search field",
                            inputType = MdsInputType.BOLD
                        ) {

                        }

                        Spacer(Modifier.height(20.dp))

                        var showLabel by remember { mutableStateOf(false) }
                        var required by remember { mutableStateOf(false) }
                        var showDescription by remember { mutableStateOf(false) }
                        var showHelperText by remember { mutableStateOf(false) }
                        var showMaxLength by remember { mutableStateOf(false) }


                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "show label",
                                style = SoptTheme.typography.body1,
                                color = SoptTheme.colors.fg.neutral.default
                            )

                            MdsToggle(
                                selected = showLabel,
                                size = MdsToggleSize.SMALL,
                            ) { showLabel = !showLabel }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "required",
                                style = SoptTheme.typography.body1,
                                color = SoptTheme.colors.fg.neutral.default
                            )

                            MdsToggle(
                                selected = required,
                                size = MdsToggleSize.SMALL,
                            ) { required = !required }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "show description",
                                style = SoptTheme.typography.body1,
                                color = SoptTheme.colors.fg.neutral.default
                            )

                            MdsToggle(
                                selected = showDescription,
                                size = MdsToggleSize.SMALL,
                            ) { showDescription = !showDescription }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "show helper text",
                                style = SoptTheme.typography.body1,
                                color = SoptTheme.colors.fg.neutral.default
                            )

                            MdsToggle(
                                selected = showHelperText,
                                size = MdsToggleSize.SMALL,
                            ) { showHelperText = !showHelperText }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "show max length",
                                style = SoptTheme.typography.body1,
                                color = SoptTheme.colors.fg.neutral.default
                            )

                            MdsToggle(
                                selected = showMaxLength,
                                size = MdsToggleSize.SMALL,
                            ) { showMaxLength = !showMaxLength }
                        }

                        Text(
                            text = "Text Field",
                            style = SoptTheme.typography.title2,
                            color = SoptTheme.colors.fg.neutral.default
                        )

                        MdsTextField(
                            state = searchText,
                            placeholder = "Default Text Field",
                            label = if (showLabel) "Label" else null,
                            required = required,
                            description = if(showDescription) "Description" else null,
                            helperText = if(showHelperText) "Helper Text" else null,
                            errorText = "10자 이상은 입력할 수 없습니다.",
                            isError = if(showMaxLength) searchText.text.length > 10 else false,
                            maxLength = if(showMaxLength) 20 else null,
                            inputTransformation = if(showMaxLength) InputTransformation.maxLength(20) else null
                        )

                        Spacer(Modifier.height(20.dp))

                        Text(
                            text = "Text Area",
                            style = SoptTheme.typography.title2,
                            color = SoptTheme.colors.fg.neutral.default
                        )

                        MdsTextArea(
                            state = searchText,
                            placeholder = "Default Text Area",
                            label = if (showLabel) "Label" else null,
                            required = required,
                            description = if(showDescription) "Description" else null,
                            helperText = if(showHelperText) "Helper Text" else null,
                            errorText = "10자 이상은 입력할 수 없습니다.",
                            isError = if(showMaxLength) searchText.text.length > 10 else false,
                            maxLength = if(showMaxLength) 20 else null,
                        )
                    }
                }
            }
        }
    }
}
