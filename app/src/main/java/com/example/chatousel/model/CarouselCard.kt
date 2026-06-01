package com.example.chatousel.model

import androidx.annotation.DrawableRes

sealed interface CarouselCard {
    val id: String

    data class Image(
        override val id: String,
        @DrawableRes val imageRes: Int,
        val title: String,
        val body: String,
        val primaryAction: String,
        val secondaryAction: String? = null,
    ) : CarouselCard

    data class Poll(
        override val id: String,
        val question: String,
        val options: List<String>,
    ) : CarouselCard

    data class Feedback(
        override val id: String,
        val prompt: String,
        val initialRating: Int = 0
    ) : CarouselCard
}
