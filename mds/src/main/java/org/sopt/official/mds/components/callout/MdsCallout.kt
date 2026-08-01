package org.sopt.official.mds.components.callout

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.official.mds.components.button.MdsTextButton
import org.sopt.official.mds.components.button.MdsTextButtonSize
import org.sopt.official.mds.components.button.MdsTextButtonType
import org.sopt.official.mds.theme.SoptTheme

@Composable
fun MdsCallout(
    text: String,
    modifier: Modifier = Modifier,
    type: MdsCalloutType = MdsCalloutType.INFORMATION,
    @DrawableRes icon: Int? = null,
    buttonText: String? = null,
    onButtonClick: (() -> Unit)? = null
) {
    val colors = type.colors()
    val shape = RoundedCornerShape(10.dp)

    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .background(colors.background)
            .border(1.dp, colors.border, shape)
            .padding(horizontal = 18.dp, vertical = 14.dp)
    ) {
        icon?.let {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = colors.icon,
                modifier = Modifier.size(20.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = text,
                style = SoptTheme.typography.body.b2,
                color = colors.text
            )

            if (buttonText != null && onButtonClick != null) {
                MdsTextButton(
                    text = buttonText,
                    type = MdsTextButtonType.EMPHASIS,
                    size = MdsTextButtonSize.SMALL,
                    onClick = onButtonClick
                )
            }
        }
    }
}
