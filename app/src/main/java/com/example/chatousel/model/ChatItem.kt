package com.example.chatousel.model

import androidx.annotation.DrawableRes

sealed interface ChatItem {
    val id: String

    data class IncomingMessage(
        override val id: String,
        val text: String,
        val time: String? = null,
        @DrawableRes val avatarRes: Int,
    ) : ChatItem


    data class Carousel(
        override val id: String,
        val cards: List<CarouselCard>,
    ) : ChatItem

    data class CallSummary(
        override val id: String,
        val duration: String,
        val time: String,
        val bullets: List<String>,
    ) : ChatItem

    data class Divider(
        override val id: String,
        val label: String,
    ) : ChatItem

    data class RatingPrompt(
        override val id: String,
        val question: String,
        val initialRating: Int = 0
    ) : ChatItem
}
