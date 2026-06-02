package com.example.chatousel.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatousel.R
import com.example.chatousel.model.CarouselCard
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.equalColors

@Composable
fun ImageCard(
    card: CarouselCard.Image,
    modifier: Modifier = Modifier,
    onPrimaryClick: (CarouselCard.Image) -> Unit = {},
    onSecondaryClick: (CarouselCard.Image) -> Unit = {},
) {
    CarouselCardSurface(modifier = modifier) {
        Image(
            painter = painterResource(card.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier.padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = card.body,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.equalColors.primaryText,
            )
            HorizontalDivider(
                color = MaterialTheme.equalColors.secondaryText.copy(alpha = 0.6f)
            )


            TextButton(
                onClick = { onPrimaryClick(card) },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = card.primaryAction,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.equalColors.actionGreen,
                    fontWeight = FontWeight.Bold
                )
            }
            HorizontalDivider(
                color = MaterialTheme.equalColors.secondaryText.copy(alpha = 0.6f)
            )

            TextButton(
                onClick = { onSecondaryClick(card) },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = card.secondaryAction.orEmpty(),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.equalColors.actionGreen,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

@Composable
internal fun CarouselCardSurface(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 1.dp,
        shadowElevation = 1.dp,
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = content
        )
    }
}

@EqualPreview
@Composable
fun ImageCardPreview() {
    ChatouselTheme {
        ImageCard(
            card = CarouselCard.Image(
                id = "argentina-card",
                imageRes = R.drawable.argentina,
                title = "Argentina",
                body = "The defending champions will compete in Group J against Algeria, Austria, and Jordan",
                primaryAction = "View Schedule",
                secondaryAction = "View Details",
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
