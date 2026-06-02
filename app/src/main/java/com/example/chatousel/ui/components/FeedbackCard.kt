package com.example.chatousel.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatousel.model.CarouselCard
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.equalColors

@Composable
fun FeedbackCard(
    card: CarouselCard.Feedback,
    selectedRating: Int,
    onRatingSelected: (CarouselCard.Feedback, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    CarouselCardSurface(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            Text(
                text = card.prompt,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.equalColors.primaryText,
                fontWeight = FontWeight.SemiBold,
            )
            RatingStars(
                selectedRating = selectedRating,
                onRatingSelected = { rating -> onRatingSelected(card, rating) },
            )
            Text(
                text = "Tap a star to rate this assistant response.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.equalColors.secondaryText,
            )
        }
    }
}

@EqualPreview
@Composable
fun FeedbackCardPreview() {
    ChatouselTheme {
        FeedbackCard(
            card = CarouselCard.Feedback(
                id = "carousel-feedback",
                prompt = "How useful was this carousel summary?",
            ),
            selectedRating = 4,
            onRatingSelected = { _, _ -> },
            modifier = Modifier.padding(16.dp)
        )
    }
}
