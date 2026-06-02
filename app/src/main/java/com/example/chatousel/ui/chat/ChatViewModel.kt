package com.example.chatousel.ui.chat

import androidx.lifecycle.ViewModel
import com.example.chatousel.mockdata.EqualMockData
import com.example.chatousel.model.CarouselCard
import com.example.chatousel.model.ChatItem
import com.example.chatousel.model.ChatUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ChatViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(EqualMockData.initialState)
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    fun onPollOptionSelected(pollId: String, option: String) {
        _uiState.update { currentState ->
            val previousOption = currentState.selectedPollOptions[pollId]
            if (previousOption == option) return@update currentState

            val newItems = currentState.items.map { item ->
                if (item is ChatItem.Carousel) {
                    val updatedCards = item.cards.map { card ->
                        if (card is CarouselCard.Poll && card.id == pollId) {
                            val updatedVotes = card.votes.toMutableMap()
                            // Decrement previous selection if any
                            previousOption?.let { prev ->
                                updatedVotes[prev] = (updatedVotes[prev] ?: 1).minus(1).coerceAtLeast(0)
                            }
                            // Increment new selection
                            updatedVotes[option] = (updatedVotes[option] ?: 0).plus(1)
                            card.copy(votes = updatedVotes)
                        } else {
                            card
                        }
                    }
                    item.copy(cards = updatedCards)
                } else {
                    item
                }
            }

            currentState.copy(
                items = newItems,
                selectedPollOptions = currentState.selectedPollOptions + (pollId to option)
            )
        }
    }

    fun onCarouselFeedbackRatingSet(cardId: String, rating: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedCarouselRatings = currentState.selectedCarouselRatings + (cardId to rating)
            )
        }
    }

    fun onCallRatingSet(ratingId: String, rating: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                callRating = currentState.callRating + (ratingId to rating)
            )
        }
    }
}