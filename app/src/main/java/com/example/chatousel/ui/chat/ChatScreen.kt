package com.example.chatousel.ui.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatousel.model.ChatItem
import com.example.chatousel.ui.components.*
import com.example.chatousel.ui.theme.equalColors
import com.example.chatousel.ui.theme.spacing12
import com.example.chatousel.ui.theme.spacing16
import com.example.chatousel.ui.theme.spacing8

@Composable
fun ChatScreen(
    viewModel: ChatViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                contact = uiState.contact,
                onBackClick = { /* Handle back */ },
                onCallClick = { /* Handle call */ },
                onMenuClick = { /* Handle menu */ }
            )
        },
        containerColor = MaterialTheme.equalColors.chatBackground,
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(vertical = spacing16),
        ) {
            items(
                items = uiState.items,
                key = { it.id }
            ) { item ->
                when (item) {
                    is ChatItem.IncomingMessage -> ChatBubble(
                        text = item.text,
                        avatarRes = item.avatarRes,
                        time = item.time,
                        modifier = Modifier.padding(bottom = spacing12)
                    )

                    is ChatItem.CallSummary -> CallSummaryCard(
                        duration = item.duration,
                        bullets = item.bullets,
                        modifier = Modifier.padding(bottom = spacing12),
                        onShareClick = { /* Handle share */ }
                    )

                    is ChatItem.Divider -> TimelineDivider(
                        label = item.label,
                        modifier = Modifier.padding(vertical = spacing8)
                    )

                    is ChatItem.RatingPrompt -> RatingPromptCard(
                        question = item.question,
                        selectedRating = uiState.callRating[item.id] ?: item.initialRating,
                        onRatingSelected = { rating ->
                            viewModel.onCallRatingSet(item.id, rating)
                        },
                        modifier = Modifier.padding(bottom = spacing12)
                    )

                    is ChatItem.Carousel -> CarouselSection(
                        cards = item.cards,
                        selectedPollOptions = uiState.selectedPollOptions,
                        selectedRatings = uiState.selectedCarouselRatings,
                        onPollOptionSelected = { card, option ->
                            viewModel.onPollOptionSelected(card.id, option)
                        },
                        onRatingSelected = { card, rating ->
                            viewModel.onCarouselFeedbackRatingSet(card.id, rating)
                        },
                        modifier = Modifier.padding(vertical = spacing12)
                    )
                }
            }
        }
    }
}