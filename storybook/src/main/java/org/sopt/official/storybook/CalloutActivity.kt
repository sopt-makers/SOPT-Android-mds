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
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
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
import org.sopt.official.mds.R
import org.sopt.official.mds.components.button.MdsActionButton
import org.sopt.official.mds.components.button.MdsActionButtonSize
import org.sopt.official.mds.components.callout.MdsCallout
import org.sopt.official.mds.components.callout.MdsCalloutType
import org.sopt.official.mds.components.input.MdsTextField
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
                        val title = remember { TextFieldState() }
                        var calloutButton by remember { mutableStateOf("") }
                        val button = remember { TextFieldState() }

                        Text(
                            text = "Callout",
                            style = SoptTheme.typography.title1,
                            color = SoptTheme.colors.fg.neutral.bold,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MdsTextField(
                                state = title,
                                placeholder = "Callout 제목을 입력하세요",
                                modifier = Modifier.weight(1f)
                            )

                            MdsActionButton(
                                text = "적용",
                                size = MdsActionButtonSize.MEDIUM,
                            ) {
                                calloutTitle = title.text.toString()
                                title.clearText()
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MdsTextField(
                                state = button,
                                placeholder = "Callout 버튼 내용을 입력하세요",
                                modifier = Modifier.weight(1f)
                            )

                            MdsActionButton(
                                text = "적용",
                                size = MdsActionButtonSize.MEDIUM,
                            ) {
                                calloutButton = button.text.toString()
                                button.clearText()
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
