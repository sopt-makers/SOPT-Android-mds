package org.sopt.official.storybook

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.theme.SoptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoptTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val context = LocalContext.current

                    LazyColumn(
                        modifier = Modifier
                            .background(SoptTheme.colors.bg.layer.default)
                            .padding(innerPadding)
                            .padding(horizontal = 10.dp)
                            .fillMaxSize()
                    ) {
                        item {
                            Item(
                                text = "Theme"
                            ) {
                                Intent(context, ThemeActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }
                        item {
                            Item(
                                text = "Avatar"
                            ) {
                                Intent(context, AvatarActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }

                        item {
                            Item(
                                text = "Button"
                            ) {
                                Intent(context, ButtonActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }

                        item {
                            Item(
                                text = "Chip"
                            ) {
                                Intent(context, ChipActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }

                        item {
                            Item(
                                text = "Input"
                            ) {
                                Intent(context, InputActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }

                        item {
                            Item(
                                text = "Control"
                            ) {
                                Intent(context, ControlActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }

                        item {
                            Item(
                                text = "Callout"
                            ) {
                                Intent(context, CalloutActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }

                        item {
                            Item(
                                text = "Dialog"
                            ) {
                                Intent(context, DialogActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }

                        item {
                            Item(
                                text = "Tag"
                            ) {
                                Intent(context, TagActivity::class.java).apply {
                                    context.startActivity(this)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun Item(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        color = SoptTheme.colors.fg.neutral.bold,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(10.dp)
    )
}
