package com.example.chatousel.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chatousel.R
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.equalColors
import com.example.chatousel.ui.theme.icon40
import com.example.chatousel.ui.theme.spacing0
import com.example.chatousel.ui.theme.spacing12
import com.example.chatousel.ui.theme.spacing16
import com.example.chatousel.ui.theme.spacing4

@Composable
fun ChatBubble(
    text: String,
    @DrawableRes avatarRes: Int,
    modifier: Modifier = Modifier,
    time: String? = null,
) {
    TimelineRow(
        avatar = {
            Image(
                painter = painterResource(avatarRes),
                contentDescription = null,
                modifier = Modifier
                    .size(icon40)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
        },
        modifier = modifier,
    ) {
        Surface(
            color = MaterialTheme.equalColors.incomingBubble,
            shape = RoundedCornerShape(spacing0, spacing16, spacing16, spacing16),
            tonalElevation = 0.dp,
        ) {
            Column(
                modifier = Modifier.padding(horizontal = spacing16, vertical = spacing12),
                verticalArrangement = Arrangement.spacedBy(spacing4),
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.equalColors.primaryText,
                )
                time?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.equalColors.secondaryText,
                        modifier = Modifier.align(Alignment.End),
                    )
                }
            }
        }
    }
}

@EqualPreview
@Composable
fun ChatBubblePreview() {
    ChatouselTheme {
        ChatBubble(
            text = "Are you calling about your order that includes your LED strip light?",
            avatarRes = R.drawable.avatar,
            time = "10:07 AM"
        )
    }
}
