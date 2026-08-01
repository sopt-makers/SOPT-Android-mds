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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.R
import org.sopt.official.mds.components.chip.MdsChip
import org.sopt.official.mds.components.tag.MdsTag
import org.sopt.official.mds.components.tag.MdsTagEmphasis
import org.sopt.official.mds.components.tag.MdsTagShape
import org.sopt.official.mds.components.tag.MdsTagSize
import org.sopt.official.mds.components.tag.MdsTagType
import org.sopt.official.mds.theme.SoptTheme

private val tagTypeList = listOf("Default", "Primary", "Secondary")

class TagActivity : ComponentActivity() {
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
                            )
                    ) {
                        var tagType by remember { mutableStateOf(tagTypeList[0]) }
                        var iconOn by remember { mutableStateOf(false) }
                        Text(
                            text = "Tag",
                            style = SoptTheme.typography.title.t1,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            repeat(3) {
                                MdsChip(
                                    text = tagTypeList[it],
                                    selected = tagType == tagTypeList[it],
                                ) {
                                    tagType = tagTypeList[it]
                                }
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = iconOn,
                                onCheckedChange = { iconOn = it }
                            )

                            Text(
                                text = "icon on",
                                style = SoptTheme.typography.body.b1,
                                color = SoptTheme.colors.fg.neutral.default
                            )
                        }


                        val type = when (tagType) {
                            "Primary" -> MdsTagType.PRIMARY
                            "Secondary" -> MdsTagType.SECONDARY
                            "Default" -> MdsTagType.DEFAULT
                            else -> MdsTagType.DEFAULT
                        }

                        Row(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                        ) {
                            MdsTag(
                                text = tagType,
                                type = type,
                                emphasis = MdsTagEmphasis.SOLID,
                                size = MdsTagSize.SMALL,
                                shape = MdsTagShape.RECT,
                                icon = if (iconOn) R.drawable.ic_pin_filled else null
                            )
                            MdsTag(
                                text = tagType,
                                type = type,
                                emphasis = MdsTagEmphasis.SUBTLE,
                                size = MdsTagSize.SMALL,
                                shape = MdsTagShape.RECT,
                                icon = if (iconOn) R.drawable.ic_pin_filled else null
                            )
                            MdsTag(
                                text = tagType,
                                type = type,
                                emphasis = MdsTagEmphasis.SOLID,
                                size = MdsTagSize.MEDIUM,
                                shape = MdsTagShape.RECT,
                                icon = if (iconOn) R.drawable.ic_pin_filled else null
                            )

                            MdsTag(
                                text = tagType,
                                type = type,
                                emphasis = MdsTagEmphasis.SUBTLE,
                                size = MdsTagSize.MEDIUM,
                                shape = MdsTagShape.RECT,
                                icon = if (iconOn) R.drawable.ic_pin_filled else null
                            )

                        }
                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Row(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                        ) {
                            MdsTag(
                                text = tagType,
                                type = type,
                                emphasis = MdsTagEmphasis.SOLID,
                                size = MdsTagSize.SMALL,
                                shape = MdsTagShape.PILL,
                                icon = if (iconOn) R.drawable.ic_pin_filled else null
                            )
                            MdsTag(
                                text = tagType,
                                type = type,
                                emphasis = MdsTagEmphasis.SUBTLE,
                                size = MdsTagSize.SMALL,
                                shape = MdsTagShape.PILL,
                                icon = if (iconOn) R.drawable.ic_pin_filled else null
                            )
                            MdsTag(
                                text = tagType,
                                type = type,
                                emphasis = MdsTagEmphasis.SOLID,
                                size = MdsTagSize.MEDIUM,
                                shape = MdsTagShape.PILL,
                                icon = if (iconOn) R.drawable.ic_pin_filled else null
                            )

                            MdsTag(
                                text = tagType,
                                type = type,
                                emphasis = MdsTagEmphasis.SUBTLE,
                                size = MdsTagSize.MEDIUM,
                                shape = MdsTagShape.PILL,
                                icon = if (iconOn) R.drawable.ic_pin_filled else null
                            )
                        }
                    }
                }
            }
        }
    }
}
