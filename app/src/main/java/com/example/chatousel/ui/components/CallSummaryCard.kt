package com.example.chatousel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.equalColors

@Composable
fun CallSummaryCard(
    duration: String,
    bullets: List<String>,
    modifier: Modifier = Modifier,
    onShareClick: () -> Unit = {},
) {
    TimelineRow(
        avatar = { AssistantAvatar() },
        trailing = { ShareButton(onClick = onShareClick) },
        modifier = modifier,
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(4.dp, 18.dp, 18.dp, 18.dp),
            tonalElevation = 0.dp,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                AudioPlayerStub(duration = duration)
                Text(
                    text = "Call Summary",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.equalColors.secondaryText,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = bullets.joinToString(separator = "\n") { "- $it" },
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.equalColors.primaryText,
                )
            }
        }
    }
}

@Composable
private fun AudioPlayerStub(duration: String) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play audio",
                tint = MaterialTheme.equalColors.actionGreen,
                modifier = Modifier.size(34.dp),
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .size(height = 4.dp, width = 1.dp)
                    .clip(RoundedCornerShape(50))
                    .background(MaterialTheme.equalColors.primaryText),
            )
            Text(
                text = duration,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.equalColors.primaryText,
            )
        }
    }
}

@Composable
private fun ShareButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(52.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Icon(
            imageVector = Icons.Default.Share,
            contentDescription = "Share summary",
            tint = MaterialTheme.equalColors.actionGreen,
        )
    }
}

@EqualPreview
@Composable
fun CallSummaryCardPreview() {
    ChatouselTheme {
        CallSummaryCard(
            duration = "00:29",
            bullets = listOf(
                "An automated call came in from Amazon, asking about an order that included an LED strip light.",
                "They were expecting a \"yes, no, or repeat\" response, but the call ended before I could get any more details for you!",
            )
        )
    }
}