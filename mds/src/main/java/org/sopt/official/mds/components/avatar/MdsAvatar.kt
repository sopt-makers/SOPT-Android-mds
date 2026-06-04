package org.sopt.official.mds.components.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import org.sopt.official.mds.R
import org.sopt.official.mds.theme.SoptTheme

@Composable
fun MdsAvatar(
    imageUrl: String?,
    size: Dp,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(SoptTheme.colors.bg.neutral.ghost)
            .border(
                width = Dp.Hairline,
                color = SoptTheme.colors.stroke.neutral.ghost,
                shape = CircleShape
            ),
    ) {
        val state = painter.state.collectAsState().value

        when (state) {
            is AsyncImagePainter.State.Success -> {
                SubcomposeAsyncImageContent()
            }

            else -> {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_user_filled),
                    contentDescription = contentDescription,
                    tint = SoptTheme.colors.fg.neutral.ghost,
                    modifier = Modifier
                        .size(size)
                        .padding(size / 4)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0XFFFFFF)
@Composable
private fun MdsAvatarPreview() {
    SoptTheme {
        MdsAvatar(
            imageUrl = null,
            size = 40.dp
        )
    }
}
