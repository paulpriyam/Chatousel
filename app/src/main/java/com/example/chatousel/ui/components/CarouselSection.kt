package com.example.chatousel.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatousel.mockdata.EqualMockData
import com.example.chatousel.model.CarouselCard
import com.example.chatousel.model.ChatItem
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.pagerSize
import com.example.chatousel.ui.theme.spacing12
import com.example.chatousel.ui.theme.spacing28
import com.example.chatousel.ui.theme.spacing40
import com.example.chatousel.ui.theme.spacing8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselSection(
    cards: List<CarouselCard>,
    selectedPollOptions: Map<String, String>,
    selectedRatings: Map<String, Int>,
    onPollOptionSelected: (CarouselCard.Poll, String) -> Unit,
    onRatingSelected: (CarouselCard.Feedback, Int) -> Unit,
    modifier: Modifier = Modifier,
    onImagePrimaryClick: (CarouselCard.Image) -> Unit = {},
    onImageSecondaryClick: (CarouselCard.Image) -> Unit = {},
) {
    val pagerState = rememberPagerState(pageCount = { cards.size })

    HorizontalPager(
        state = pagerState,
        modifier = modifier.heightIn(min = pagerSize),
        pageSize = PageSize.Fixed(pagerSize),
        pageSpacing = spacing12,
        contentPadding = PaddingValues(start = spacing40, end = spacing28),
        key = { page -> cards[page].id },
    ) { page ->
        val card = cards[page]
        when (card) {
            is CarouselCard.Image -> ImageCard(
                card = card,
                modifier = Modifier.padding(vertical = spacing8),
                onPrimaryClick = onImagePrimaryClick,
                onSecondaryClick = onImageSecondaryClick,
            )

            is CarouselCard.Poll -> PollCard(
                card = card,
                selectedOption = selectedPollOptions[card.id],
                onOptionSelected = onPollOptionSelected,
                modifier = Modifier.padding(vertical = spacing8),
            )

            is CarouselCard.Feedback -> FeedbackCard(
                card = card,
                selectedRating = selectedRatings[card.id] ?: card.initialRating,
                onRatingSelected = onRatingSelected,
                modifier = Modifier.padding(vertical = spacing8),
            )
        }
    }
}

@EqualPreview
@Composable
private fun CarouselSectionPreview() {
    val carouselItem = EqualMockData.initialState.items.filterIsInstance<ChatItem.Carousel>().firstOrNull()
    ChatouselTheme {
        CarouselSection(
            cards = carouselItem?.cards ?: emptyList(),
            selectedPollOptions = emptyMap(),
            selectedRatings = emptyMap(),
            onPollOptionSelected = { _, _ -> },
            onRatingSelected = { _, _ -> }
        )
    }
}
