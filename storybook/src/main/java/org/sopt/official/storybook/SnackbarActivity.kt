package org.sopt.official.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.components.button.MdsActionButton
import org.sopt.official.mds.components.button.MdsActionButtonSize
import org.sopt.official.mds.components.button.MdsActionButtonType
import org.sopt.official.mds.components.snackbar.LocalMdsSnackbarTrigger
import org.sopt.official.mds.components.snackbar.MdsSnackBarVariant
import org.sopt.official.mds.components.snackbar.MdsSnackbarHost
import org.sopt.official.mds.components.snackbar.MdsSnackbarProvider
import org.sopt.official.mds.components.snackbar.MdsSnackbarRequest
import org.sopt.official.mds.theme.SoptTheme

class SnackbarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoptTheme {
                MdsSnackbarProvider { snackBarRequest ->
                    val showMdsSnackbar = LocalMdsSnackbarTrigger.current

                    Scaffold(
                        snackbarHost = { MdsSnackbarHost(snackBarRequest) },
                        containerColor = SoptTheme.colors.bg.layer.basement,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        val snackBarRequestList = listOf(
                            "Default" to MdsSnackbarRequest(
                                message = "저는 토스트예요.",
                                variant = MdsSnackBarVariant.SUCCESS
                            ),
                            "Success" to MdsSnackbarRequest(
                                message = "프로젝트가 등록되었어요",
                                variant = MdsSnackBarVariant.SUCCESS,
                                showIcon = true
                            ),
                            "Success with two lines" to MdsSnackbarRequest(
                                message = "두 줄이 필요하면 두 줄 쓰세요. (세 줄은 안돼) 근데 중요한 건 간결하게 쓰는 것!",
                                variant = MdsSnackBarVariant.SUCCESS,
                                showIcon = true
                            ),
                            "Success with button" to MdsSnackbarRequest(
                                message = "프로젝트가 등록되었어요",
                                variant = MdsSnackBarVariant.SUCCESS,
                                showIcon = true,
                                onButtonClick = { }
                            ),
                            "Alert" to MdsSnackbarRequest(
                                message = "이메일을 다시 입력해주세요.",
                                variant = MdsSnackBarVariant.ALERT,
                                showIcon = true
                            ),
                            "Alert with two lines" to MdsSnackbarRequest(
                                message = "두 줄이 필요하면 두 줄 쓰세요. (세 줄은 안돼) 근데 중요한 건 간결하게 쓰는 것!",
                                variant = MdsSnackBarVariant.ALERT,
                                showIcon = true
                            ),
                            "Alert with button" to MdsSnackbarRequest(
                                message = "이메일을 다시 입력해주세요.",
                                variant = MdsSnackBarVariant.ALERT,
                                showIcon = true,
                                onButtonClick = { }
                            ),
                            "Error" to MdsSnackbarRequest(
                                message = "업로드에 실패했어요.",
                                variant = MdsSnackBarVariant.ERROR,
                                showIcon = true
                            ),
                            "Error with two lines" to MdsSnackbarRequest(
                                message = "두 줄이 필요하면 두 줄 쓰세요. (세 줄은 안돼) 근데 중요한 건 간결하게 쓰는 것!",
                                variant = MdsSnackBarVariant.ERROR,
                                showIcon = true
                            ),
                            "Error with button" to MdsSnackbarRequest(
                                message = "업로드에 실패했어요.",
                                variant = MdsSnackBarVariant.ERROR,
                                showIcon = true,
                                onButtonClick = { }
                            )
                        )

                        Column(
                            modifier = Modifier
                                .padding(it)
                                .padding(10.dp)
                                .verticalScroll(
                                    rememberScrollState()
                                ),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                        ) {
                            Text(
                                text = "Snack bar",
                                style = SoptTheme.typography.title1,
                                color = SoptTheme.colors.fg.neutral.bold,
                                modifier = Modifier
                                    .padding(vertical = 20.dp)
                            )

                            repeat(snackBarRequestList.size) { index ->
                                MdsActionButton(
                                    text = snackBarRequestList[index].first,
                                    type = MdsActionButtonType.PRIMARY,
                                    size = MdsActionButtonSize.MEDIUM
                                ) {
                                    showMdsSnackbar(snackBarRequestList[index].second)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
