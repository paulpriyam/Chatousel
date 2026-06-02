package com.example.chatousel.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.equalColors

@Composable
fun RatingPromptCard(
    question: String,
    selectedRating: Int,
    onRatingSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.padding(horizontal = 40.dp),
        color = MaterialTheme.equalColors.incomingBubble,
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 0.dp,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 22.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            RatingStars(
                selectedRating = selectedRating,
                onRatingSelected = onRatingSelected,
            )
            Text(
                text = question,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.equalColors.primaryText,
            )
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
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        repeat(5) { index ->
            val rating = index + 1
            IconButton(
                onClick = { onRatingSelected(rating) },
                modifier = Modifier.size(42.dp),
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
                        MaterialTheme.colorScheme.outline
                    },
                    modifier = Modifier.size(36.dp),
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
            question = "How would you rate the summary?",
            selectedRating = 3,
            onRatingSelected = {}
        )
    }
}