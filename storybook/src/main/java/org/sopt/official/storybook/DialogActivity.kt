package org.sopt.official.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.components.button.MdsActionButton
import org.sopt.official.mds.components.button.MdsActionButtonSize
import org.sopt.official.mds.components.control.radio.MdsRadio
import org.sopt.official.mds.components.control.toggle.MdsToggle
import org.sopt.official.mds.components.control.toggle.MdsToggleSize
import org.sopt.official.mds.components.dialog.MdsDialog
import org.sopt.official.mds.components.dialog.MdsDialogType
import org.sopt.official.mds.components.input.MdsTextField
import org.sopt.official.mds.theme.SoptTheme

class DialogActivity : ComponentActivity() {
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
                    var showDialog by remember { mutableStateOf(false) }

                    var dialogType by remember { mutableStateOf(MdsDialogType.DEFAULT) }

                    var showDescription by remember { mutableStateOf(false) }
                    val title by remember { mutableStateOf(TextFieldState("Title text")) }
                    var description by remember { mutableStateOf(TextFieldState("Description text")) }

                    var showCheckbox by remember { mutableStateOf(false) }
                    val checkboxText by remember { mutableStateOf(TextFieldState()) }
                    var checkboxSelected by remember { mutableStateOf(false) }

                    if (showDialog) {
                        MdsDialog(
                            title = title.text.toString(),
                            description = if (showDescription) description.text.toString() else null,
                            onDismiss = { showDialog = false },
                            positiveButtonText = "닫기",
                            type = dialogType,
                            negativeButtonText = "닫기",
                            onNegativeButtonClick = { showDialog = false },
                            onPositiveButtonClick = { showDialog = false },
                            checkboxEnabled = showCheckbox,
                            checkboxText = checkboxText.text.toString(),
                            checkboxSelected = checkboxSelected,
                            onCheckboxClick = { selected -> checkboxSelected = selected }
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(it)
                            .padding(10.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Text(
                            text = "Dialog",
                            style = SoptTheme.typography.title1,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )

                        Text(
                            text = "Dialog type",
                            style = SoptTheme.typography.body1,
                            color = SoptTheme.colors.fg.neutral.default,
                        )

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(
                                MdsDialogType.entries.size
                            ) { type ->
                                MdsRadio(
                                    text = MdsDialogType.entries[type].name,
                                    selected = MdsDialogType.entries[type] == dialogType
                                ) {
                                    dialogType = MdsDialogType.entries[type]
                                }
                            }
                        }

                        Text(
                            text = "Dialog title",
                            style = SoptTheme.typography.body1,
                            color = SoptTheme.colors.fg.neutral.default,
                        )

                        MdsTextField(
                            state = title,
                            placeholder = "Title"
                        )

                        Text(
                            text = "Dialog description",
                            style = SoptTheme.typography.body1,
                            color = SoptTheme.colors.fg.neutral.default,
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MdsToggle(
                                selected = showDescription,
                                size = MdsToggleSize.SMALL,
                            ) { showDescription = !showDescription }

                            MdsTextField(
                                state = description,
                                placeholder = "Description"
                            )
                        }

                        Text(
                            text = "Checkbox",
                            style = SoptTheme.typography.body1,
                            color = SoptTheme.colors.fg.neutral.default,
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MdsToggle(
                                selected = showCheckbox,
                                size = MdsToggleSize.SMALL,
                            ) { showCheckbox = !showCheckbox }

                            MdsTextField(
                                state = checkboxText,
                                placeholder = "Checkbox text"
                            )
                        }

                        MdsActionButton(
                            text = "다이얼로그 보러가기",
                            size = MdsActionButtonSize.LARGE,
                        ) {
                            showDialog = true
                        }
                    }
                }
            }
        }
    }
}
