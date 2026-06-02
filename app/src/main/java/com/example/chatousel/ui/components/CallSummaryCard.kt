package com.example.chatousel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.chatousel.ui.theme.icon24
import com.example.chatousel.ui.theme.icon32
import com.example.chatousel.ui.theme.icon40
import com.example.chatousel.ui.theme.icon54
import com.example.chatousel.ui.theme.roundedCorner16
import com.example.chatousel.ui.theme.roundedCorner4
import com.example.chatousel.ui.theme.spacing0
import com.example.chatousel.ui.theme.spacing12
import com.example.chatousel.ui.theme.spacing16

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
            shape = RoundedCornerShape(roundedCorner4, roundedCorner16, roundedCorner16, roundedCorner16),
            tonalElevation = 0.dp,
        ) {
            Column(
                modifier = Modifier.padding(spacing16),
                verticalArrangement = Arrangement.spacedBy(spacing16),
            ) {
                AudioPlayerStub(duration = duration)
                Text(
                    text = "Call Summary",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.equalColors.secondaryText,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = bullets.joinToString(separator = "\n") { "- $it" },
                    style = MaterialTheme.typography.bodyMedium,
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
        shape = RoundedCornerShape(roundedCorner16),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = spacing16, vertical = spacing12),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(spacing12),
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play audio",
                tint = MaterialTheme.equalColors.actionGreen,
                modifier = Modifier.size(icon32),
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.equalColors.primaryText),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "00:00",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.equalColors.primaryText,
                    )
                    Text(
                        text = duration,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.equalColors.primaryText,
                    )
                }
            }
            Surface(
                color = MaterialTheme.equalColors.primaryText.copy(alpha = 0.1f),
                shape = CircleShape,
            ) {
                Text(
                    text = "1x",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.equalColors.primaryText,
                )
            }
        }
    }
}

@Composable
private fun ShareButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(icon40)
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