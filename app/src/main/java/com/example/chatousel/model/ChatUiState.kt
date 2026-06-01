package com.example.chatousel.model

import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val phone: String,
    @DrawableRes val avatarRes: Int,
)

data class ChatUiState(
    val contact: Contact,
    val items: List<ChatItem>,
    val selectedPollOptions: Map<String, String> = emptyMap(),
    val selectedCarouselRatings: Map<String, Int> = emptyMap(),
    val callRating: Map<String,Int> = emptyMap(),
)
