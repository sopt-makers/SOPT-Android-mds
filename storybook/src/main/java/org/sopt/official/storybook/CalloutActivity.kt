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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.R
import org.sopt.official.mds.components.button.MdsActionButton
import org.sopt.official.mds.components.button.MdsActionButtonSize
import org.sopt.official.mds.components.callout.MdsCallout
import org.sopt.official.mds.components.callout.MdsCalloutType
import org.sopt.official.mds.theme.SoptTheme

class CalloutActivity : ComponentActivity() {
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
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        var calloutTitle by remember { mutableStateOf("Callout") }
                        var title by remember { mutableStateOf("") }
                        var calloutButton by remember { mutableStateOf("button") }
                        var button by remember { mutableStateOf("") }

                        Text(
                            text = "Callout",
                            style = SoptTheme.typography.title.t1,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            TextField(
                                value = title,
                                onValueChange = { title = it },
                                placeholder = {
                                    Text(
                                        text = "Title",
                                        style = SoptTheme.typography.body.b1,
                                        color = SoptTheme.colors.fg.neutral.default
                                    )
                                },
                                modifier = Modifier.weight(1f)
                            )
                            MdsActionButton(
                                text = "적용",
                                size = MdsActionButtonSize.LARGE,
                            ) {
                                calloutTitle = title
                                title = ""
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            TextField(
                                value = button,
                                onValueChange = { button = it },
                                placeholder = {
                                    Text(
                                        text = "Button",
                                        style = SoptTheme.typography.body.b1,
                                        color = SoptTheme.colors.fg.neutral.default
                                    )
                                },
                                modifier = Modifier.weight(1f)
                            )
                            MdsActionButton(
                                text = "적용",
                                size = MdsActionButtonSize.LARGE,
                            ) {
                                calloutButton = button
                                button = ""
                            }
                        }

                        MdsCallout(
                            text = calloutTitle
                        )
                        MdsCallout(
                            text = calloutTitle,
                            icon = R.drawable.ic_alert_circle_outlined
                        )
                        MdsCallout(
                            text = calloutTitle,
                            icon = R.drawable.ic_alert_circle_outlined,
                            buttonText = calloutButton,
                            onButtonClick = { }
                        )

                        MdsCallout(
                            text = calloutTitle,
                            type = MdsCalloutType.DANGER
                        )
                        MdsCallout(
                            text = calloutTitle,
                            icon = R.drawable.ic_alert_circle_outlined,
                            type = MdsCalloutType.DANGER
                        )
                        MdsCallout(
                            text = calloutTitle,
                            icon = R.drawable.ic_alert_circle_outlined,
                            buttonText = calloutButton,
                            onButtonClick = { },
                            type = MdsCalloutType.DANGER
                        )
                    }
                }
            }
        }
    }
}
