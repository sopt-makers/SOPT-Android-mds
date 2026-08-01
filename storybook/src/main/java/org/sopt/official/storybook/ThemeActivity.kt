package org.sopt.official.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.sopt.official.mds.components.chip.MdsChip
import org.sopt.official.mds.theme.SoptTheme
import org.sopt.official.mds.theme.blueTokens
import org.sopt.official.mds.theme.grayTokens
import org.sopt.official.mds.theme.greenTokens
import org.sopt.official.mds.theme.orangeTokens
import org.sopt.official.mds.theme.redTokens
import org.sopt.official.mds.theme.yellowTokens

class ThemeActivity : ComponentActivity() {
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
                    val tabs = listOf("Typography", "Colors")

                    val pagerState = rememberPagerState(
                        initialPage = 0,
                        pageCount = { 2 }
                    )
                    val scope = rememberCoroutineScope()

                    Column(
                        modifier = Modifier
                            .padding(it)
                    ) {
                        PrimaryTabRow(
                            selectedTabIndex = pagerState.currentPage,
                            containerColor = SoptTheme.colors.bg.layer.basement,
                            contentColor = SoptTheme.colors.fg.neutral.default
                        ) {
                            tabs.forEachIndexed { index, title ->
                                Tab(
                                    selected = pagerState.currentPage == index,
                                    onClick = {
                                        scope.launch {
                                            pagerState.animateScrollToPage(index)
                                        }
                                    },
                                    text = {
                                        Text(
                                            text = title,
                                            style = SoptTheme.typography.title4
                                        )
                                    }
                                )
                            }
                        }
                        HorizontalPager(
                            state = pagerState,
                            modifier = Modifier.fillMaxSize()
                        ) { page ->
                            when (page) {
                                0 -> TypographySection()
                                1 -> ColorsSection()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TypographyCard(
    title: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(SoptTheme.colors.bg.layer.default)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = title,
            style = textStyle,
            color = SoptTheme.colors.fg.neutral.bold
        )

        Text(
            text = "가나다라\nABCD\n12345",
            style = textStyle,
            color = SoptTheme.colors.fg.neutral.bold
        )

        Text(
            text = buildString {
                append(textStyle.fontSize.value.toInt())
                append("sp")
            },
            style = textStyle,
            color = SoptTheme.colors.fg.neutral.subtle
        )
    }
}

@Composable
fun ColorCard(
    name: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(SoptTheme.colors.bg.layer.default)
            .border(
                1.dp,
                SoptTheme.colors.stroke.neutral.subtle,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color)
                .border(
                    1.dp,
                    SoptTheme.colors.stroke.neutral.subtle,
                    RoundedCornerShape(8.dp)
                )
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = name,
                style = SoptTheme.typography.label3,
                color = SoptTheme.colors.fg.neutral.bold,
                minLines = 2,
            )

            Text(
                text = "#${String.format("%06X", color.toArgb() and 0xFFFFFF)}",
                style = SoptTheme.typography.body3,
                color = SoptTheme.colors.fg.neutral.default
            )
        }
    }
}

@Composable
private fun TypographySection() {
    val typographyItems = listOf(
        "heading1" to SoptTheme.typography.heading1,
        "heading2" to SoptTheme.typography.heading2,
        "heading3" to SoptTheme.typography.heading3,
        "heading4" to SoptTheme.typography.heading4,

        "title1" to SoptTheme.typography.title1,
        "title2" to SoptTheme.typography.title2,
        "title3" to SoptTheme.typography.title3,
        "title4" to SoptTheme.typography.title4,
        "title5" to SoptTheme.typography.title5,

        "body1" to SoptTheme.typography.body1,
        "body2" to SoptTheme.typography.body2,
        "body3" to SoptTheme.typography.body3,

        "label1" to SoptTheme.typography.label1,
        "label2" to SoptTheme.typography.label2,
        "label3" to SoptTheme.typography.label3,
        "label4" to SoptTheme.typography.label4,
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(typographyItems.size) {
            TypographyCard(
                typographyItems[it].first,
                typographyItems[it].second
            )
        }
    }
}

@Composable
private fun ColorsSection() {
    var colorType by remember { mutableStateOf("Base") }

    Column(
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MdsChip(
                text = "Base Token",
                selected = colorType == "Base",
            ) {
                colorType = "Base"
            }

            MdsChip(
                text = "Semantic Token",
                selected = colorType == "Semantic",
            ) {
                colorType = "Semantic"
            }
        }

        if (colorType == "Base") {
            BaseColorTokenSection()
        } else {
            SemanticColorTokenSection()
        }
    }
}

@Composable
private fun BaseColorTokenSection() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Gray",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(grayTokens.size) {
            ColorCard(
                name = grayTokens[it].name,
                color = grayTokens[it].color
            )
        }

        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Orange",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(orangeTokens.size) {
            ColorCard(
                name = orangeTokens[it].name,
                color = orangeTokens[it].color
            )
        }

        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Blue",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(blueTokens.size) {
            ColorCard(
                name = blueTokens[it].name,
                color = blueTokens[it].color
            )
        }

        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Red",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(redTokens.size) {
            ColorCard(
                name = redTokens[it].name,
                color = redTokens[it].color
            )
        }

        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Green",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(greenTokens.size) {
            ColorCard(
                name = greenTokens[it].name,
                color = greenTokens[it].color
            )
        }

        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Yellow",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(yellowTokens.size) {
            ColorCard(
                name = yellowTokens[it].name,
                color = yellowTokens[it].color
            )
        }
    }
}

@Composable
private fun SemanticColorTokenSection() {
    val bgColors = listOf(
        "neutral.inverse" to SoptTheme.colors.bg.neutral.inverse,
        "neutral.inverseHover" to SoptTheme.colors.bg.neutral.inverseHover,
        "neutral.inversePressed" to SoptTheme.colors.bg.neutral.inversePressed,
        "neutral.bold" to SoptTheme.colors.bg.neutral.bold,
        "neutral.boldDisabled" to SoptTheme.colors.bg.neutral.boldDisabled,
        "neutral.default" to SoptTheme.colors.bg.neutral.default,
        "neutral.defaultHover" to SoptTheme.colors.bg.neutral.defaultHover,
        "neutral.defaultPressed" to SoptTheme.colors.bg.neutral.defaultPressed,
        "neutral.defaultDisabled" to SoptTheme.colors.bg.neutral.defaultDisabled,
        "neutral.subtle" to SoptTheme.colors.bg.neutral.subtle,
        "neutral.subtleHover" to SoptTheme.colors.bg.neutral.subtleHover,
        "neutral.subtlePressed" to SoptTheme.colors.bg.neutral.subtlePressed,
        "neutral.ghost" to SoptTheme.colors.bg.neutral.ghost,
        "neutral.ghostHover" to SoptTheme.colors.bg.neutral.ghostHover,
        "neutral.ghostPressed" to SoptTheme.colors.bg.neutral.ghostPressed,

        "brand.default" to SoptTheme.colors.bg.brand.default,
        "brand.subtle" to SoptTheme.colors.bg.brand.subtle,
        "brand.ghost" to SoptTheme.colors.bg.brand.ghost,

        "secondary.default" to SoptTheme.colors.bg.secondary.default,
        "secondary.defaultHover" to SoptTheme.colors.bg.secondary.defaultHover,
        "secondary.defaultPressed" to SoptTheme.colors.bg.secondary.defaultPressed,
        "secondary.subtle" to SoptTheme.colors.bg.secondary.subtle,
        "secondary.ghost" to SoptTheme.colors.bg.secondary.ghost,

        "information.ghost" to SoptTheme.colors.bg.information.ghost,

        "success.ghost" to SoptTheme.colors.bg.success.ghost,

        "danger.default" to SoptTheme.colors.bg.danger.default,
        "danger.defaultHover" to SoptTheme.colors.bg.danger.defaultHover,
        "danger.defaultPressed" to SoptTheme.colors.bg.danger.defaultPressed,
        "danger.ghost" to SoptTheme.colors.bg.danger.ghost,

        "dim.default" to SoptTheme.colors.bg.dim.default,

        "layer.basement" to SoptTheme.colors.bg.layer.basement,
        "layer.basementHover" to SoptTheme.colors.bg.layer.basementHover,
        "layer.default" to SoptTheme.colors.bg.layer.default,
        "layer.defaultHover" to SoptTheme.colors.bg.layer.defaultHover
    )

    val fgColors = listOf(
        "neutral.bold" to SoptTheme.colors.fg.neutral.bold,
        "neutral.default" to SoptTheme.colors.fg.neutral.default,
        "neutral.defaultDisabled" to SoptTheme.colors.fg.neutral.defaultDisabled,
        "neutral.subtle" to SoptTheme.colors.fg.neutral.subtle,
        "neutral.ghost" to SoptTheme.colors.fg.neutral.ghost,
        "neutral.ghostDisabled" to SoptTheme.colors.fg.neutral.ghostDisabled,
        "neutral.inverse" to SoptTheme.colors.fg.neutral.inverse,

        "brand.default" to SoptTheme.colors.fg.brand.default,

        "secondary.default" to SoptTheme.colors.fg.secondary.default,

        "success.bold" to SoptTheme.colors.fg.success.bold,
        "success.default" to SoptTheme.colors.fg.success.default,
        "success.subtle" to SoptTheme.colors.fg.success.subtle,

        "danger.bold" to SoptTheme.colors.fg.danger.bold,
        "danger.default" to SoptTheme.colors.fg.danger.default,
        "danger.subtle" to SoptTheme.colors.fg.danger.subtle,

        "attention.bold" to SoptTheme.colors.fg.attention.bold,
        "attention.default" to SoptTheme.colors.fg.attention.default,
        "attention.subtle" to SoptTheme.colors.fg.attention.subtle,

        "information.default" to SoptTheme.colors.fg.information.default,
        "information.subtle" to SoptTheme.colors.fg.information.subtle
    )

    val strokeColors = listOf(
        "neutral.default" to SoptTheme.colors.stroke.neutral.default,
        "neutral.defaultFocused" to SoptTheme.colors.stroke.neutral.defaultFocused,
        "neutral.defaultDisabled" to SoptTheme.colors.stroke.neutral.defaultDisabled,
        "neutral.inverse" to SoptTheme.colors.stroke.neutral.inverse,
        "neutral.subtle" to SoptTheme.colors.stroke.neutral.subtle,
        "neutral.ghost" to SoptTheme.colors.stroke.neutral.ghost,

        "brand.default" to SoptTheme.colors.stroke.brand.default,
        "brand.subtle" to SoptTheme.colors.stroke.brand.subtle,

        "secondary.default" to SoptTheme.colors.stroke.secondary.default,
        "secondary.subtle" to SoptTheme.colors.stroke.secondary.subtle,

        "information.subtle" to SoptTheme.colors.stroke.information.subtle,

        "danger.default" to SoptTheme.colors.stroke.danger.default
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Background",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(bgColors.size) {
            ColorCard(
                name = bgColors[it].first,
                color = bgColors[it].second
            )
        }

        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Foreground",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(fgColors.size) {
            ColorCard(
                name = fgColors[it].first,
                color = fgColors[it].second
            )
        }

        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Text(
                text = "Stroke",
                style = SoptTheme.typography.heading4,
                color = SoptTheme.colors.fg.neutral.bold
            )
        }

        items(strokeColors.size) {
            ColorCard(
                name = strokeColors[it].first,
                color = strokeColors[it].second
            )
        }
    }
}
