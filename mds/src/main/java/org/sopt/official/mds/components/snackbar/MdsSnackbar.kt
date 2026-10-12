package org.sopt.official.mds.components.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.components.button.MdsTextButton
import org.sopt.official.mds.components.button.MdsTextButtonSize
import org.sopt.official.mds.components.button.MdsTextButtonType
import org.sopt.official.mds.theme.SoptTheme

@Composable
internal fun MdsSnackbar(
    message: String,
    variant: MdsSnackBarVariant = MdsSnackBarVariant.SUCCESS,
    showIcon: Boolean = false,
    buttonText: String = "보러가기",
    onButtonClick: (() -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(SoptTheme.colors.bg.neutral.inverse)
            .padding(vertical = 14.dp, horizontal = 16.dp)
    ) {
        if (showIcon) {
            Icon(
                imageVector = ImageVector.vectorResource(variant.icon),
                contentDescription = null,
                tint = variant.iconColor(),
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = message,
            style = SoptTheme.typography.label3,
            color = SoptTheme.colors.fg.neutral.inverse,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )

        onButtonClick?.let {
            Spacer(modifier = Modifier.width(14.dp))

            MdsTextButton(
                text = buttonText,
                type = MdsTextButtonType.EMPHASIS,
                size = MdsTextButtonSize.MEDIUM,
                onClick = onButtonClick,
            )
        }
    }
}
