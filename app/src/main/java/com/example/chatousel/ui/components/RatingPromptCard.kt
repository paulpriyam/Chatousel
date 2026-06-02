package com.example.chatousel.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star as FilledStar
import androidx.compose.material.icons.outlined.Star as OutlinedStar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.equalColors
import com.example.chatousel.ui.theme.icon32
import com.example.chatousel.ui.theme.icon40
import com.example.chatousel.ui.theme.roundedCorner16
import com.example.chatousel.ui.theme.spacing16
import com.example.chatousel.ui.theme.spacing24
import com.example.chatousel.ui.theme.spacing40
import com.example.chatousel.ui.theme.spacing8

@Composable
fun RatingPromptCard(
    question: String,
    selectedRating: Int,
    onRatingSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spacing16)
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(roundedCorner16),
            tonalElevation = 0.dp,
        ) {
            Column(
                modifier = Modifier.padding(horizontal = spacing40, vertical = spacing24),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(spacing16)
            ) {
                RatingStars(
                    selectedRating = selectedRating,
                    onRatingSelected = onRatingSelected,
                )
                Text(
                    text = question,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.equalColors.primaryText,
                )
            }
        }
    }
}

@Composable
fun RatingStars(
    selectedRating: Int,
    onRatingSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing8),
    ) {
        repeat(5) { index ->
            val rating = index + 1
            IconButton(
                onClick = { onRatingSelected(rating) },
                modifier = Modifier.size(icon40),
            ) {
                Icon(
                    imageVector = if (rating <= selectedRating) {
                        Icons.Filled.FilledStar
                    } else {
                        Icons.Outlined.OutlinedStar
                    },
                    contentDescription = "$rating star",
                    tint = if (rating <= selectedRating) {
                        MaterialTheme.equalColors.actionGreen
                    } else {
                        MaterialTheme.equalColors.secondaryText.copy(alpha = 0.2f)
                    },
                    modifier = Modifier.size(icon32),
                )
            }
        }
    }
}

@EqualPreview
@Composable
fun RatingPromptCardPreview() {
    ChatouselTheme {
        RatingPromptCard(
            question = "How would you rate your call",
            selectedRating = 0,
            onRatingSelected = {}
        )
    }
}
