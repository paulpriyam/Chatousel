package com.example.chatousel.mockdata

import com.example.chatousel.R
import com.example.chatousel.model.CarouselCard
import com.example.chatousel.model.ChatItem
import com.example.chatousel.model.ChatUiState
import com.example.chatousel.model.Contact

object EqualMockData {


    val initialState = ChatUiState(
        contact = Contact(
            name = "Amazon",
            phone = "+912268910001",
            avatarRes = R.drawable.avatar,
        ),
        items = listOf(
            ChatItem.IncomingMessage(
                id = "message-order",
                text = "Are you calling about your order that includes your LED strip light?",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.IncomingMessage(
                id = "message-response",
                text = "form you can say yes, no, or repeat.",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary",
                duration = "00:29",
                time = "10:07 AM",
                bullets = listOf(
                    "An automated call came in from Amazon, asking about an order that included an LED strip light.",
                    "They were expecting a \"yes, no, or repeat\" response, but the call ended before I could get any more details for you!",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended",
                label = "Call Ended 10:07 AM",
            ),
            ChatItem.RatingPrompt(
                id = "amazon-call-rating",
                question = "How would you rate your call ",
            ),
            ChatItem.Carousel(
                id = "country-carousel",
                cards = listOf(
                    CarouselCard.Image(
                        id = "argentina-card",
                        imageRes = R.drawable.argentina,
                        title = "Argentina",
                        body = "The defending champions will compete in Group J against Algeria, Austria, and Jordan",
                        primaryAction = "View Schedule",
                        secondaryAction = "View Details",
                    ),
                    CarouselCard.Poll(
                        id = "callback-poll",
                        question = "Can Argentina retain their world cup title",
                        options = listOf("Yes", "No", "Maybe", "Can't Say"),
                    ),
                    CarouselCard.Image(
                        id = "portugal-card",
                        imageRes = R.drawable.portugal,
                        title = "Portugal",
                        body = "Portugal is in Group K and will play against DR Congo, Uzbekistan, and Colombia",
                        primaryAction = "View Schedule",
                        secondaryAction = "Dismiss",
                    ),
                    CarouselCard.Feedback(
                        id = "carousel-feedback",
                        prompt = "How useful was this carousel summary?",
                    ),
                ),
            )
        ),
    )
}
