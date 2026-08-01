package org.sopt.official.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.clearText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.components.avatar.MdsAvatar
import org.sopt.official.mds.components.avatar.MdsAvatarFallbackType
import org.sopt.official.mds.components.control.radio.MdsRadio
import org.sopt.official.mds.components.input.MdsTextField
import org.sopt.official.mds.theme.SoptTheme

private val items = listOf(
    24.dp,
    32.dp,
    48.dp,
    56.dp,
    72.dp,
    80.dp,
    120.dp,
    180.dp
)

class AvatarActivity : ComponentActivity() {
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

                    val state = remember { TextFieldState() }
                    var imageUrl by remember { mutableStateOf("") }
                    var radioType by remember { mutableStateOf("Ghost") }

                    LazyColumn(
                        modifier = Modifier
                            .padding(it)
                            .padding(horizontal = 20.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                focusManager.clearFocus()
                            }
                    ) {
                        stickyHeader {
                            Column(
                                modifier = Modifier.background(SoptTheme.colors.bg.layer.basement)
                            ) {
                                Text(
                                    text = "Avatar",
                                    style = SoptTheme.typography.title.t1,
                                    color = SoptTheme.colors.fg.neutral.bold,
                                    modifier = Modifier
                                        .padding(vertical = 20.dp)
                                )

                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    MdsRadio(
                                        text = "Ghost",
                                        selected = radioType == "Ghost",
                                        enabled = true
                                    ) {
                                        radioType = "Ghost"
                                    }

                                    MdsRadio(
                                        text = "Subtle",
                                        selected = radioType == "Subtle",
                                        enabled = true

                                    ) {
                                        radioType = "Subtle"
                                    }

                                    MdsRadio(
                                        text = "Image",
                                        selected = radioType == "Image",
                                        enabled = true
                                    ) {
                                        radioType = "Image"
                                    }
                                }

                                Spacer(Modifier.height(10.dp))

                                if (radioType == "Image") {
                                    MdsTextField(
                                        state = state,
                                        helperText = "이미지 링크를 넣어주세요",
                                        onKeyboardAction = {
                                            imageUrl = state.text.toString()
                                            state.clearText()
                                            focusManager.clearFocus()
                                        }
                                    )
                                }
                            }
                        }

                        items(
                            items = items,
                        ) { size ->
                            Spacer(Modifier.height(10.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                MdsAvatar(
                                    size = size,
                                    fallbackType = if (radioType == "Subtle") MdsAvatarFallbackType.SUBTLE else MdsAvatarFallbackType.GHOST,
                                    imageUrl = if (radioType == "Image") imageUrl else null,
                                )
                                MdsAvatar(
                                    size = size,
                                    fallbackType = if (radioType == "Subtle") MdsAvatarFallbackType.SUBTLE else MdsAvatarFallbackType.GHOST,
                                    imageUrl = if (radioType == "Image") imageUrl else null,
                                    strokeColor = SoptTheme.colors.stroke.secondary.default
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
