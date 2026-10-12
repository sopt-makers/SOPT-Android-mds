package org.sopt.official.mds.components.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay

private val MDS_SNACKBAR_TIMEMILLIS = 4.seconds

const val MDS_SNACKBAR_ENTER_ANIMATION_MILLIS = 250
const val MDS_SNACKBAR_EXIT_ANIMATION_MILLIS = 200

typealias MdsSnackbarTrigger = (MdsSnackbarRequest) -> Unit

val LocalMdsSnackbarTrigger = compositionLocalOf<MdsSnackbarTrigger> {
    error("MdsSnackbarTrigger is not provided.")
}

@Composable
fun MdsSnackbarProvider(
    content: @Composable (MdsSnackbarRequest?) -> Unit,
) {
    val snackbarQueue = remember {
        Channel<MdsSnackbarRequest>(Channel.UNLIMITED)
    }

    val showMdsSnackbar: MdsSnackbarTrigger = { request ->
        snackbarQueue.trySend(request)
    }

    var snackbarRequest by remember {
        mutableStateOf<MdsSnackbarRequest?>(null)
    }


    LaunchedEffect(snackbarQueue) {
        for (request in snackbarQueue) {
            snackbarRequest = request
            delay(MDS_SNACKBAR_TIMEMILLIS)
            snackbarRequest = null
            delay(MDS_SNACKBAR_EXIT_ANIMATION_MILLIS.milliseconds)
        }
    }

    CompositionLocalProvider(
        LocalMdsSnackbarTrigger provides showMdsSnackbar,
    ) {
        content(snackbarRequest)
    }
}
