package org.sopt.official.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.components.chip.MdsChip
import org.sopt.official.mds.components.chip.MdsChipSize
import org.sopt.official.mds.components.chip.MdsChipType
import org.sopt.official.mds.components.control.toggle.MdsToggle
import org.sopt.official.mds.components.control.toggle.MdsToggleSize
import org.sopt.official.mds.theme.SoptTheme

class ChipActivity : ComponentActivity() {
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
                    var outlinedSmall by remember { mutableStateOf(0) }
                    var outlinedMedium by remember { mutableStateOf(0) }
                    var solidSmall by remember { mutableStateOf(0) }
                    var solidMedium by remember { mutableStateOf(0) }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier
                            .padding(it)
                    ) {
                        var chipEnabled by remember { mutableStateOf(true) }
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(horizontal = 20.dp)
                        ) {
                            Text(
                                text = "Chip",
                                style = SoptTheme.typography.title.t1,
                                color = SoptTheme.colors.fg.neutral.bold,
                                modifier = Modifier.padding(top = 10.dp)
                            )

                            MdsToggle(
                                selected = chipEnabled,
                                size = MdsToggleSize.SMALL,
                                enabled = true,
                                onClick = { enabled -> chipEnabled = enabled }
                            )
                        }

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp)
                        ) {
                            items(5) {
                                MdsChip(
                                    text = "Small Outlined",
                                    selected = outlinedSmall == it,
                                    onClick = { outlinedSmall = it },
                                    size = MdsChipSize.SMALL,
                                    type = MdsChipType.OUTLINED,
                                    enabled = chipEnabled
                                )
                            }
                        }

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp)
                        ) {
                            items(5) {
                                MdsChip(
                                    text = "Medium Outlined",
                                    selected = outlinedMedium == it,
                                    onClick = { outlinedMedium = it },
                                    size = MdsChipSize.MEDIUM,
                                    type = MdsChipType.OUTLINED,
                                    enabled = chipEnabled
                                )
                            }
                        }

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp)
                        ) {
                            items(5) {
                                MdsChip(
                                    text = "Small Solid",
                                    selected = solidSmall == it,
                                    onClick = { solidSmall = it },
                                    size = MdsChipSize.SMALL,
                                    type = MdsChipType.SOLID,
                                    enabled = chipEnabled
                                )
                            }
                        }

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp)
                        ) {
                            items(5) {
                                MdsChip(
                                    text = "Medium Solid",
                                    selected = solidMedium == it,
                                    onClick = { solidMedium = it },
                                    size = MdsChipSize.MEDIUM,
                                    type = MdsChipType.SOLID,
                                    enabled = chipEnabled
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
