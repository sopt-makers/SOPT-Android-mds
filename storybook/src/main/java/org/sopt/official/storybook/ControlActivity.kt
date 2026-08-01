package org.sopt.official.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.components.control.checkbox.MdsCheckbox
import org.sopt.official.mds.components.control.checkbox.MdsCheckboxSize
import org.sopt.official.mds.components.control.radio.MdsRadio
import org.sopt.official.mds.components.control.radio.MdsRadioSize
import org.sopt.official.mds.components.control.toggle.MdsToggle
import org.sopt.official.mds.components.control.toggle.MdsToggleSize
import org.sopt.official.mds.theme.SoptTheme

class ControlActivity : ComponentActivity() {
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
                    var checkboxEnabled by remember { mutableStateOf(true) }
                    val smallCheckbox = remember { mutableStateListOf(false, false, false, false) }
                    val largeCheckbox = remember { mutableStateListOf(false, false, false, false) }

                    var radioEnabled by remember { mutableStateOf(true) }
                    var smallRadioSelected by remember { mutableIntStateOf(1) }
                    var largeRadioSelected by remember { mutableIntStateOf(1) }

                    var toggleEnabled by remember { mutableStateOf(true) }
                    var smallToggleSelected by remember { mutableStateOf(false) }
                    var largeToggleSelected by remember { mutableStateOf(false) }


                    Column(
                        modifier = Modifier
                            .padding(it)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        Text(
                            text = "Control",
                            style = SoptTheme.typography.title.t1,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )

                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            Text(
                                text = "Checkbox",
                                style = SoptTheme.typography.title.t2,
                                color = SoptTheme.colors.fg.neutral.default
                            )

                            MdsToggle(
                                selected = checkboxEnabled,
                                size = MdsToggleSize.SMALL,
                                enabled = true,
                                onClick = { enabled -> checkboxEnabled = enabled }
                            )
                        }

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            items(4) { small ->
                                MdsCheckbox(
                                    text = "Small $small",
                                    selected = smallCheckbox[small],
                                    size = MdsCheckboxSize.SMALL,
                                    enabled = checkboxEnabled
                                ) {
                                    smallCheckbox[small] = !smallCheckbox[small]
                                }
                            }
                        }

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(4) { large ->
                                MdsCheckbox(
                                    text = "Large $large",
                                    selected = largeCheckbox[large],
                                    size = MdsCheckboxSize.LARGE,
                                    enabled = checkboxEnabled
                                ) {
                                    largeCheckbox[large] = !largeCheckbox[large]
                                }
                            }
                        }

                        Spacer(Modifier.height(30.dp))

                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            Text(
                                text = "Radio",
                                style = SoptTheme.typography.title.t2,
                                color = SoptTheme.colors.fg.neutral.default
                            )

                            MdsToggle(
                                selected = radioEnabled,
                                size = MdsToggleSize.SMALL,
                                enabled = true,
                                onClick = { enabled -> radioEnabled = enabled }
                            )
                        }

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(6) { radio ->
                                MdsRadio(
                                    text = "Small $radio",
                                    selected = radio == smallRadioSelected,
                                    size = MdsRadioSize.SMALL,
                                    enabled = radioEnabled
                                ) {
                                    smallRadioSelected = radio
                                }
                            }
                        }

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(6) { radio ->
                                MdsRadio(
                                    text = "Large $radio",
                                    selected = radio == largeRadioSelected,
                                    size = MdsRadioSize.LARGE,
                                    enabled = radioEnabled
                                ) {
                                    largeRadioSelected = radio
                                }
                            }
                        }

                        Spacer(Modifier.height(30.dp))

                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            Text(
                                text = "Toggle",
                                style = SoptTheme.typography.title.t2,
                                color = SoptTheme.colors.fg.neutral.default
                            )

                            MdsToggle(
                                selected = toggleEnabled,
                                size = MdsToggleSize.SMALL,
                                enabled = true,
                                onClick = { enabled -> toggleEnabled = enabled }
                            )
                        }

                        MdsToggle(
                            selected = smallToggleSelected,
                            size = MdsToggleSize.SMALL,
                            enabled = toggleEnabled,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            smallToggleSelected = !smallToggleSelected
                        }

                        MdsToggle(
                            selected = largeToggleSelected,
                            size = MdsToggleSize.LARGE,
                            enabled = toggleEnabled,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            largeToggleSelected = !largeToggleSelected
                        }
                    }
                }
            }
        }
    }
}
