package com.example.chatousel.mockdata

import com.example.chatousel.R
import com.example.chatousel.model.CarouselCard
import com.example.chatousel.model.ChatItem
import com.example.chatousel.model.ChatUiState
import com.example.chatousel.model.Contact
import com.example.chatousel.ui.components.PollCard

object EqualMockData {


    val initialState = ChatUiState(
        contact = Contact(
            name = "Amazon",
            phone = "+912268910001",
            avatarRes = R.drawable.avatar,
        ),
        items = listOf(

            ChatItem.Divider(
                id = "call-started",
                label = "Call Started 10:00 AM",
            ),

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
                id = "call-rating",
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
                        votes = mapOf("Yes" to 12, "No" to 3, "Maybe" to 1, "Can't Say" to 0)
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
            ),

            ChatItem.Divider(
                id = "call-started-1",
                label = "Call Started 11:00 AM",
            ),

            ChatItem.IncomingMessage(
                id = "message-order-1",
                text = "Hi this is your Myntra order, would uou like to delivered it to the same address",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.IncomingMessage(
                id = "message-response-1",
                text = "form you can say yes, no, or repeat.",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary-1",
                duration = "00:29",
                time = "10:07 AM",
                bullets = listOf(
                    "An automated call came in from Myntra, asking about an order",
                    "They were expecting a \"yes, no, or repeat\" response, but the call ended before I could get any more details for you!",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended-1",
                label = "Call Ended 11:07 AM",
            ),
            ChatItem.RatingPrompt(
                id = "call-rating-1",
                question = "How would you rate your call ",
            ),

            ChatItem.Divider(
                id = "call-started-2",
                label = "Call Started 11:00 AM",
            ),

            ChatItem.IncomingMessage(
                id = "message-order-2",
                text = "Hi this is your Myntra order, would uou like to delivered it to the same address",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.IncomingMessage(
                id = "message-response-2",
                text = "form you can say yes, no, or repeat.",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary-2",
                duration = "00:29",
                time = "10:07 AM",
                bullets = listOf(
                    "An automated call came in from Myntra, asking about an order",
                    "They were expecting a \"yes, no, or repeat\" response, but the call ended before I could get any more details for you!",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended-2",
                label = "Call Ended 11:07 AM",
            ),
            ChatItem.RatingPrompt(
                id = "call-rating-2",
                question = "How would you rate your call ",
            ),
            ChatItem.Carousel(
                id = "country-carousel-2",
                cards = listOf(
                    CarouselCard.Poll(
                        id = "poll-12",
                        question = "Time to vote on the dessert – you can only pick one!",
                        options = listOf("Gulab Jamun", "Rasgulla", "Pantua"),
                        votes = mapOf("Gulab Jamun" to 10, "Rasgulla" to 12, "Pantua" to 3)
                    ),

                    CarouselCard.Poll(
                        id = "poll-22",
                        question = "Who do you think is gonna win the IPL this time??",
                        options = listOf(
                            "Rajasthan Royals",
                            "Chennai Super Kings",
                            "Mumbai Indians",
                            "Kolkata Knight Riders",
                            "RCB",
                            "Sunrisers Hyderabad",
                            "Delhi Capitals"
                        ),
                        votes = mapOf(
                            "Rajasthan Royals" to 0,
                            "Chennai Super Kings" to 0,
                            "Mumbai Indians" to 0,
                            "Kolkata Knight Riders" to 0,
                            "RCB" to 0,
                            "Sunrisers Hyderabad" to 0,
                            "Delhi Capitals" to 0
                        )
                    )
                )
            ),

            ChatItem.Divider(
                id = "call-started-3",
                label = "Call Started 12:30 PM",
            ),
            ChatItem.IncomingMessage(
                id = "message-courier",
                text = "I have a package for you from BlueDart. Can you share the OTP?",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary-3",
                duration = "01:12",
                time = "12:31 PM",
                bullets = listOf(
                    "A courier from BlueDart called regarding a package delivery.",
                    "He requested the OTP to complete the delivery process.",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended-3",
                label = "Call Ended 12:31 PM",
            ),
            ChatItem.Carousel(
                id = "european-tour",
                cards = listOf(
                    CarouselCard.Image(
                        id = "france-card",
                        imageRes = R.drawable.france,
                        title = "France",
                        body = "Visit the Eiffel Tower and enjoy the art at the Louvre in Paris.",
                        primaryAction = "View Tour",
                        secondaryAction = "Later",
                    ),
                    CarouselCard.Image(
                        id = "spain-card",
                        imageRes = R.drawable.spain,
                        title = "Spain",
                        body = "Relax on the sunny beaches of Costa del Sol or explore Madrid.",
                        primaryAction = "Get Deals",
                    ),
                    CarouselCard.Image(
                        id = "italy-card",
                        imageRes = R.drawable.italy,
                        title = "Italy",
                        body = "From Venice's canals to Rome's history, Italy has it all.",
                        primaryAction = "Explore",
                        secondaryAction = "Dismiss",
                    ),
                    CarouselCard.Poll(
                        id = "travel-preference",
                        question = "Which country would you visit first?",
                        options = listOf("France", "Spain", "Italy", "Portugal"),
                        votes = mapOf("France" to 15, "Spain" to 10, "Italy" to 25, "Portugal" to 8)
                    ),
                    CarouselCard.Feedback(
                        id = "travel-feedback",
                        prompt = "Did you find these travel suggestions helpful?",
                    )
                )
            ),
            ChatItem.Divider(
                id = "call-started-4",
                label = "Call Started 2:00 PM",
            ),
            ChatItem.IncomingMessage(
                id = "message-portugal",
                text = "Bom dia! Are you interested in our special Portugal tour packages?",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary-4",
                duration = "00:58",
                time = "2:01 PM",
                bullets = listOf(
                    "A travel agent called to promote special tour packages for Portugal.",
                    "They mentioned early bird discounts for the upcoming season.",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended-4",
                label = "Call Ended 2:01 PM",
            ),
            ChatItem.RatingPrompt(
                id = "call-rating-4",
                question = "How relevant was this travel offer to you?",
            ),
            ChatItem.Divider(
                id = "call-started-5",
                label = "Call Started 3:00 PM",
            ),
            ChatItem.IncomingMessage(
                id = "message-zomato",
                text = "Hi, I'm your Zomato delivery partner. I've reached your location.",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary-5",
                duration = "00:45",
                time = "3:01 PM",
                bullets = listOf(
                    "The delivery partner called to inform they have arrived at the gate.",
                    "They requested you to collect the order at the reception.",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended-5",
                label = "Call Ended 3:01 PM",
            ),
            ChatItem.RatingPrompt(
                id = "call-rating-5",
                question = "Rate your delivery experience",
            ),
            ChatItem.Divider(
                id = "call-started-6",
                label = "Call Started 4:15 PM",
            ),
            ChatItem.IncomingMessage(
                id = "message-bank",
                text = "This is HDFC Bank. We noticed a transaction of ₹5000. Did you authorize this?",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary-6",
                duration = "02:10",
                time = "4:17 PM",
                bullets = listOf(
                    "Security verification for a recent high-value transaction.",
                    "The transaction was confirmed as authorized by the user.",
                    "The agent provided tips on keeping the account secure.",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended-6",
                label = "Call Ended 4:17 PM",
            ),
            ChatItem.Carousel(
                id = "bank-services-carousel",
                cards = listOf(
                    CarouselCard.Poll(
                        id = "security-poll",
                        question = "Which security feature do you use most?",
                        options = listOf("App OTP", "SMS OTP", "Fingerprint", "Face ID"),
                        votes = mapOf("App OTP" to 45, "SMS OTP" to 30, "Fingerprint" to 20, "Face ID" to 5)
                    ),
                    CarouselCard.Feedback(
                        id = "bank-feedback",
                        prompt = "How satisfied are you with our fraud detection?",
                    ),
                ),
            ),
            ChatItem.Divider(
                id = "call-started-7",
                label = "Call Started 5:45 PM",
            ),
            ChatItem.IncomingMessage(
                id = "message-health",
                text = "Hello, this is Apollo Clinics. You have a health checkup scheduled for tomorrow at 9 AM.",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary-7",
                duration = "01:20",
                time = "5:46 PM",
                bullets = listOf(
                    "Reminder for the scheduled annual health checkup.",
                    "Instructions provided: Fast for 10 hours before the blood test.",
                    "Location confirmed at the main branch.",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended-7",
                label = "Call Ended 5:46 PM",
            ),
            ChatItem.RatingPrompt(
                id = "call-rating-7",
                question = "How helpful was this reminder?",
            ),
            ChatItem.Carousel(
                id = "health-tips-carousel",
                cards = listOf(
                    CarouselCard.Image(
                        id = "health-card-spain",
                        imageRes = R.drawable.spain,
                        title = "Healthy Living",
                        body = "The Mediterranean diet is one of the healthiest in the world.",
                        primaryAction = "Read More",
                    ),
                    CarouselCard.Poll(
                        id = "water-intake-poll",
                        question = "How many liters of water do you drink daily?",
                        options = listOf("Less than 1L", "1-2L", "2-3L", "More than 3L"),
                    )
                )
            ),
            ChatItem.Divider(
                id = "call-started-8",
                label = "Call Started 7:00 PM",
            ),
            ChatItem.IncomingMessage(
                id = "message-broadband",
                text = "Hi, this is Airtel Broadband. Your internet plan expires in 2 days. Would you like to renew?",
                avatarRes = R.drawable.avatar,
            ),
            ChatItem.CallSummary(
                id = "call-summary-8",
                duration = "01:50",
                time = "7:02 PM",
                bullets = listOf(
                    "Reminder about the broadband plan expiration.",
                    "Discussion about available upgrade options and discounts.",
                    "User requested a callback tomorrow morning.",
                ),
            ),
            ChatItem.Divider(
                id = "call-ended-8",
                label = "Call Ended 7:02 PM",
            ),
            ChatItem.RatingPrompt(
                id = "call-rating-8",
                question = "Rate the helpfulness of this renewal reminder",
            )
        )
    )
}
