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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.theme.SoptTheme

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
                    TokenShowcaseScreen(
                        modifier = Modifier
                            .padding(it)
                    )
                }
            }
        }
    }
}

@Composable
fun TokenShowcaseScreen(
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(SoptTheme.colors.bg.neutral.default)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        item {
            SectionTitle("Typography")
        }

        item {
            TypographySection()
        }

        item {
            SectionTitle("Background")
        }

        item {
            BgColorSection()
        }

        item {
            SectionTitle("Foreground")
        }

        item {
            FgColorSection()
        }

        item {
            SectionTitle(
                "Stroke"
            )
        }

        item {
            StrokeColorSection()
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = SoptTheme.typography.heading.h3,
        color = SoptTheme.colors.fg.neutral.bold
    )
}

@Composable
fun ColorItem(
    name: String,
    color: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color)
                .border(
                    1.dp,
                    SoptTheme.colors.stroke.neutral.subtle,
                    RoundedCornerShape(8.dp)
                )
        )

        Spacer(Modifier.width(12.dp))

        Text(
            text = name,
            style = SoptTheme.typography.body.b2,
            color = SoptTheme.colors.fg.neutral.bold
        )
    }
}

@Composable
fun TypographySection() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

        Text(
            text = "heading.h1",
            style = SoptTheme.typography.heading.h1,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "heading.h2",
            style = SoptTheme.typography.heading.h2,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "heading.h3",
            style = SoptTheme.typography.heading.h3,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "heading.h4",
            style = SoptTheme.typography.heading.h4,
            color = SoptTheme.colors.fg.neutral.default
        )

        Text(
            text = "title.t1",
            style = SoptTheme.typography.title.t1,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "title.t2",
            style = SoptTheme.typography.title.t2,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "title.t3",
            style = SoptTheme.typography.title.t3,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "title.t4",
            style = SoptTheme.typography.title.t4,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "title.t5",
            style = SoptTheme.typography.title.t5,
            color = SoptTheme.colors.fg.neutral.default
        )

        Text(
            text = "body.b1",
            style = SoptTheme.typography.body.b1,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "body.b2",
            style = SoptTheme.typography.body.b2,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "body.b3",
            style = SoptTheme.typography.body.b3,
            color = SoptTheme.colors.fg.neutral.default
        )

        Text(
            text = "label.l1",
            style = SoptTheme.typography.label.l1,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "label.l2",
            style = SoptTheme.typography.label.l2,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "label.l3",
            style = SoptTheme.typography.label.l3,
            color = SoptTheme.colors.fg.neutral.default
        )
        Text(
            text = "label.l4",
            style = SoptTheme.typography.label.l4,
            color = SoptTheme.colors.fg.neutral.default
        )
    }
}

@Composable
fun BgColorSection() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        ColorItem("bg.neutral.inverse", SoptTheme.colors.bg.neutral.inverse)
        ColorItem("bg.neutral.inverseHover", SoptTheme.colors.bg.neutral.inverseHover)
        ColorItem("bg.neutral.inversePressed", SoptTheme.colors.bg.neutral.inversePressed)

        ColorItem("bg.neutral.bold", SoptTheme.colors.bg.neutral.bold)
        ColorItem("bg.neutral.boldDisabled", SoptTheme.colors.bg.neutral.boldDisabled)

        ColorItem("bg.neutral.default", SoptTheme.colors.bg.neutral.default)
        ColorItem("bg.neutral.defaultHover", SoptTheme.colors.bg.neutral.defaultHover)
        ColorItem("bg.neutral.defaultPressed", SoptTheme.colors.bg.neutral.defaultPressed)
        ColorItem("bg.neutral.defaultDisabled", SoptTheme.colors.bg.neutral.defaultDisabled)

        ColorItem("bg.neutral.subtle", SoptTheme.colors.bg.neutral.subtle)
        ColorItem("bg.neutral.subtleHover", SoptTheme.colors.bg.neutral.subtleHover)
        ColorItem("bg.neutral.subtlePressed", SoptTheme.colors.bg.neutral.subtlePressed)

        ColorItem("bg.neutral.ghost", SoptTheme.colors.bg.neutral.ghost)
        ColorItem("bg.neutral.ghostHover", SoptTheme.colors.bg.neutral.ghostHover)
        ColorItem("bg.neutral.ghostPressed", SoptTheme.colors.bg.neutral.ghostPressed)

        ColorItem("bg.brand.default", SoptTheme.colors.bg.brand.default)
        ColorItem("bg.brand.subtle", SoptTheme.colors.bg.brand.subtle)
        ColorItem("bg.brand.ghost", SoptTheme.colors.bg.brand.ghost)

        ColorItem("bg.secondary.default", SoptTheme.colors.bg.secondary.default)
        ColorItem("bg.secondary.defaultHover", SoptTheme.colors.bg.secondary.defaultHover)
        ColorItem("bg.secondary.defaultPressed", SoptTheme.colors.bg.secondary.defaultPressed)
        ColorItem("bg.secondary.subtle", SoptTheme.colors.bg.secondary.subtle)
        ColorItem("bg.secondary.ghost", SoptTheme.colors.bg.secondary.ghost)

        ColorItem("bg.danger.default", SoptTheme.colors.bg.danger.default)
        ColorItem("bg.danger.defaultHover", SoptTheme.colors.bg.danger.defaultHover)
        ColorItem("bg.danger.defaultPressed", SoptTheme.colors.bg.danger.defaultPressed)
        ColorItem("bg.danger.ghost", SoptTheme.colors.bg.danger.ghost)

        ColorItem("bg.success.ghost", SoptTheme.colors.bg.success.ghost)
        ColorItem("bg.information.ghost", SoptTheme.colors.bg.information.ghost)
        ColorItem("bg.dim.default", SoptTheme.colors.bg.dim.default)

        ColorItem("bg.layer.basement", SoptTheme.colors.bg.layer.basement)
        ColorItem("bg.layer.basementHover", SoptTheme.colors.bg.layer.basementHover)
        ColorItem("bg.layer.default", SoptTheme.colors.bg.layer.default)
        ColorItem("bg.layer.defaultHover", SoptTheme.colors.bg.layer.defaultHover)
    }
}

@Composable
fun FgColorSection() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        ColorItem("fg.neutral.bold", SoptTheme.colors.fg.neutral.bold)
        ColorItem("fg.neutral.default", SoptTheme.colors.fg.neutral.default)
        ColorItem("fg.neutral.defaultDisabled", SoptTheme.colors.fg.neutral.defaultDisabled)
        ColorItem("fg.neutral.subtle", SoptTheme.colors.fg.neutral.subtle)
        ColorItem("fg.neutral.ghost", SoptTheme.colors.fg.neutral.ghost)
        ColorItem("fg.neutral.ghostDisabled", SoptTheme.colors.fg.neutral.ghostDisabled)
        ColorItem("fg.neutral.inverse", SoptTheme.colors.fg.neutral.inverse)

        ColorItem("fg.brand.default", SoptTheme.colors.fg.brand.default)

        ColorItem("fg.secondary.default", SoptTheme.colors.fg.secondary.default)

        ColorItem("fg.success.bold", SoptTheme.colors.fg.success.bold)
        ColorItem("fg.success.default", SoptTheme.colors.fg.success.default)
        ColorItem("fg.success.subtle", SoptTheme.colors.fg.success.subtle)

        ColorItem("fg.danger.bold", SoptTheme.colors.fg.danger.bold)
        ColorItem("fg.danger.default", SoptTheme.colors.fg.danger.default)
        ColorItem("fg.danger.subtle", SoptTheme.colors.fg.danger.subtle)

        ColorItem("fg.attention.bold", SoptTheme.colors.fg.attention.bold)
        ColorItem("fg.attention.default", SoptTheme.colors.fg.attention.default)
        ColorItem("fg.attention.subtle", SoptTheme.colors.fg.attention.subtle)

        ColorItem("fg.information.default", SoptTheme.colors.fg.information.default)
        ColorItem("fg.information.subtle", SoptTheme.colors.fg.information.subtle)
    }
}

@Composable
fun StrokeColorSection() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        ColorItem("stroke.neutral.default", SoptTheme.colors.stroke.neutral.default)
        ColorItem("stroke.neutral.defaultFocused", SoptTheme.colors.stroke.neutral.defaultFocused)
        ColorItem("stroke.neutral.defaultDisabled", SoptTheme.colors.stroke.neutral.defaultDisabled)
        ColorItem("stroke.neutral.inverse", SoptTheme.colors.stroke.neutral.inverse)
        ColorItem("stroke.neutral.subtle", SoptTheme.colors.stroke.neutral.subtle)
        ColorItem("stroke.neutral.ghost", SoptTheme.colors.stroke.neutral.ghost)

        ColorItem("stroke.brand.default", SoptTheme.colors.stroke.brand.default)
        ColorItem("stroke.brand.subtle", SoptTheme.colors.stroke.brand.subtle)

        ColorItem("stroke.secondary.default", SoptTheme.colors.stroke.secondary.default)
        ColorItem("stroke.secondary.subtle", SoptTheme.colors.stroke.secondary.subtle)

        ColorItem("stroke.information.subtle", SoptTheme.colors.stroke.information.subtle)

        ColorItem("stroke.danger.default", SoptTheme.colors.stroke.danger.default)
    }
}