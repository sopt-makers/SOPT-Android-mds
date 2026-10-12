package org.sopt.official.mds.components.snackbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MdsSnackbarHost(
    request: MdsSnackbarRequest?
) {
    var displayedRequest by remember {
        mutableStateOf<MdsSnackbarRequest?>(null)
    }

    var visibilityState by remember { mutableStateOf(false) }

    LaunchedEffect(request) {
        if (request != null) {
            displayedRequest = request
            visibilityState = true
        } else {
            visibilityState = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(vertical = 14.dp, horizontal = 20.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        AnimatedVisibility(
            visible = visibilityState,
            enter = slideInVertically(
                initialOffsetY = { -it },
                animationSpec = tween(
                    durationMillis = MDS_SNACKBAR_ENTER_ANIMATION_MILLIS,
                    easing = EaseOut,
                ),
            ) + fadeIn(
                animationSpec = tween(
                    durationMillis = MDS_SNACKBAR_ENTER_ANIMATION_MILLIS,
                    easing = EaseOut,
                ),
            ),
            exit = slideOutVertically(
                targetOffsetY = { -it },
                animationSpec = tween(
                    durationMillis = MDS_SNACKBAR_EXIT_ANIMATION_MILLIS,
                    easing = EaseIn,
                ),
            ) + fadeOut(
                animationSpec = tween(
                    durationMillis = MDS_SNACKBAR_EXIT_ANIMATION_MILLIS,
                    easing = EaseIn,
                ),
            ),
        ) {
            displayedRequest?.let { snackbarRequest ->
                MdsSnackbar(
                    message = snackbarRequest.message,
                    variant = snackbarRequest.variant,
                    showIcon = snackbarRequest.showIcon,
                    buttonText = snackbarRequest.buttonText,
                    onButtonClick = snackbarRequest.onButtonClick
                )
            }
        }
    }
}
