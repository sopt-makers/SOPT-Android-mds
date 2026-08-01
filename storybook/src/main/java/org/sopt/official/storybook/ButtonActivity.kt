package org.sopt.official.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.R
import org.sopt.official.mds.components.button.MdsActionButton
import org.sopt.official.mds.components.button.MdsActionButtonSize
import org.sopt.official.mds.components.button.MdsActionButtonType
import org.sopt.official.mds.components.button.MdsFloatingButton
import org.sopt.official.mds.components.button.MdsFloatingButtonType
import org.sopt.official.mds.components.button.MdsReactionButton
import org.sopt.official.mds.components.button.MdsReactionButtonSize
import org.sopt.official.mds.components.button.MdsReactionButtonType
import org.sopt.official.mds.components.chip.MdsChip
import org.sopt.official.mds.theme.SoptTheme

private val actionButtonList = listOf("Primary", "Secondary", "Danger")
private val reactionButtonList =
    listOf(MdsReactionButtonType.SELECTED, MdsReactionButtonType.UNSELECTED)

class ButtonActivity : ComponentActivity() {
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
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .padding(10.dp)
                            .verticalScroll(
                                rememberScrollState()
                            ),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        var actionButtonType by remember { mutableStateOf(actionButtonList[0]) }
                        var reactionButtonType by remember { mutableStateOf(reactionButtonList[0]) }

                        Text(
                            text = "Button",
                            style = SoptTheme.typography.title.t1,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )

                        Text(
                            text = "Action Button",
                            style = SoptTheme.typography.title.t2,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            repeat(3) {
                                MdsChip(
                                    text = actionButtonList[it],
                                    selected = actionButtonType == actionButtonList[it],
                                ) {
                                    actionButtonType = actionButtonList[it]
                                }
                            }
                        }

                        val type = when (actionButtonType) {
                            "Primary" -> MdsActionButtonType.PRIMARY
                            "Secondary" -> MdsActionButtonType.SECONDARY
                            "Danger" -> MdsActionButtonType.DANGER
                            else -> MdsActionButtonType.PRIMARY
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {
                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.XSMALL,
                                type = type
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.XSMALL,
                                type = type,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.XSMALL,
                                type = type,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.XSMALL,
                                type = type,
                                prefixIcon = R.drawable.ic_plus_outlined,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.XSMALL,
                                type = type,
                                enabled = false,
                                prefixIcon = R.drawable.ic_plus_outlined,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {
                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.SMALL,
                                type = type
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.SMALL,
                                type = type,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.SMALL,
                                type = type,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.SMALL,
                                type = type,
                                prefixIcon = R.drawable.ic_plus_outlined,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.SMALL,
                                type = type,
                                enabled = false,
                                prefixIcon = R.drawable.ic_plus_outlined,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier
                                .horizontalScroll(
                                    rememberScrollState()
                                )
                        ) {
                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.MEDIUM,
                                type = type
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.MEDIUM,
                                type = type,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.MEDIUM,
                                type = type,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.MEDIUM,
                                type = type,
                                prefixIcon = R.drawable.ic_plus_outlined,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.MEDIUM,
                                type = type,
                                enabled = false,
                                prefixIcon = R.drawable.ic_plus_outlined,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier
                                .horizontalScroll(
                                    rememberScrollState()
                                )
                        ) {
                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.LARGE,
                                type = type
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.LARGE,
                                type = type,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.LARGE,
                                type = type,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.LARGE,
                                type = type,
                                prefixIcon = R.drawable.ic_plus_outlined,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }

                            MdsActionButton(
                                text = actionButtonType,
                                size = MdsActionButtonSize.LARGE,
                                type = type,
                                enabled = false,
                                prefixIcon = R.drawable.ic_plus_outlined,
                                suffixIcon = R.drawable.ic_chevron_right_outlined
                            ) { }
                        }

                        Text(
                            text = "Reaction Button",
                            style = SoptTheme.typography.title.t2,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                        )

                        var count by remember { mutableIntStateOf(0) }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            repeat(2) {
                                MdsChip(
                                    text = reactionButtonList[it].name.lowercase(),
                                    selected = reactionButtonType == reactionButtonList[it],
                                ) {
                                    reactionButtonType = reactionButtonList[it]
                                }
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {
                            MdsReactionButton(
                                text = "XSMALL",
                                reactionCount = count,
                                size = MdsReactionButtonSize.XSMALL,
                                type = reactionButtonType
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "XSMALL",
                                reactionCount = count,
                                size = MdsReactionButtonSize.XSMALL,
                                type = reactionButtonType,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "XSMALL",
                                reactionCount = count,
                                size = MdsReactionButtonSize.XSMALL,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "XSMALL",
                                reactionCount = count,
                                size = MdsReactionButtonSize.XSMALL,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "XSMALL",
                                reactionCount = count,
                                enabled = false,
                                size = MdsReactionButtonSize.XSMALL,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {
                            MdsReactionButton(
                                text = "SMALL",
                                reactionCount = count,
                                size = MdsReactionButtonSize.SMALL,
                                type = reactionButtonType
                            ) {
                                count++
                            }


                            MdsReactionButton(
                                text = "SMALL",
                                reactionCount = count,
                                size = MdsReactionButtonSize.SMALL,
                                type = reactionButtonType,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "SMALL",
                                reactionCount = count,
                                size = MdsReactionButtonSize.SMALL,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "SMALL",
                                reactionCount = count,
                                enabled = false,
                                size = MdsReactionButtonSize.SMALL,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {
                            MdsReactionButton(
                                text = "MEDIUM",
                                reactionCount = count,
                                size = MdsReactionButtonSize.MEDIUM,
                                type = reactionButtonType
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "MEDIUM",
                                reactionCount = count,
                                size = MdsReactionButtonSize.MEDIUM,
                                type = reactionButtonType,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "MEDIUM",
                                reactionCount = count,
                                size = MdsReactionButtonSize.MEDIUM,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "MEDIUM",
                                reactionCount = count,
                                size = MdsReactionButtonSize.MEDIUM,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "MEDIUM",
                                reactionCount = count,
                                enabled = false,
                                size = MdsReactionButtonSize.MEDIUM,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState())
                        ) {
                            MdsReactionButton(
                                text = "LARGE",
                                reactionCount = count,
                                size = MdsReactionButtonSize.LARGE,
                                type = reactionButtonType
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "LARGE",
                                reactionCount = count,
                                size = MdsReactionButtonSize.LARGE,
                                type = reactionButtonType,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "LARGE",
                                reactionCount = count,
                                size = MdsReactionButtonSize.LARGE,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "LARGE",
                                reactionCount = count,
                                size = MdsReactionButtonSize.LARGE,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }

                            MdsReactionButton(
                                text = "LARGE",
                                reactionCount = count,
                                enabled = false,
                                size = MdsReactionButtonSize.LARGE,
                                type = reactionButtonType,
                                suffixIcon = R.drawable.ic_chevron_right_outlined,
                                prefixIcon = R.drawable.ic_plus_outlined
                            ) {
                                count++
                            }
                        }

                        Text(
                            text = "Floating Button",
                            style = SoptTheme.typography.title.t2,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                        )

                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            MdsFloatingButton(
                                text = "Floating Button",
                            ) { }

                            MdsFloatingButton(
                                text = "Floating Button",
                                enabled = false
                            ) { }
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            MdsFloatingButton(
                                text = "Floating Button",
                                type = MdsFloatingButtonType.EXPANDED
                            ) { }
                            MdsFloatingButton(
                                text = "Floating Button",
                                enabled = false,
                                type = MdsFloatingButtonType.EXPANDED
                            ) { }
                        }

                        Spacer(Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}
