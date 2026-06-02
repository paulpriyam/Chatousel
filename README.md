# Chatousel

Chatousel is a modern Android application built with **Jetpack Compose** that showcases a rich, interactive chat interface. It goes beyond simple text messaging by incorporating dynamic carousels.

## 🚀 Features

- **Rich Messaging**: Supports standard incoming messages along with specialized UI components.
- **Dynamic Carousels**: A versatile carousel system within the chat that supports:
    - **Image Cards**: Engaging visuals with titles, descriptions, and action buttons.
    - **Interactive Polls**: Real-time voting interface to gather user opinions.
    - **Feedback Cards**: Integrated rating prompts for quick user feedback.
- **Call Summaries**: Clean, structured summaries of phone calls, including durations, timestamps, and bulleted highlights.
- **Star Rating Block**: Uses dividers and rating prompts to create a structured and interactive user journey.

## 🛠 Tech Stack

- **UI**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Design System**: [Material 3](https://m3.material.io/)
- **Language**: [Kotlin](https://kotlinlang.org/)
- **Architecture**: Modern Android development (MVVM/State-driven UI)
- **Min SDK**: 24
- **Target SDK**: 36

## 📁 Project Structure

- `com.example.chatousel.model`: Data models for Chat Items, Carousel Cards, and UI State.
- `com.example.chatousel.mockdata`: Contains `EqualMockData.kt`, which provides sample data to populate the rich chat interface.
- `com.example.chatousel.ui.components`: Reusable Compose components like `PollCard`.

## 📸 Getting Started

1. Clone the repository.
2. Open the project in **Android Studio (Ladybug or newer)**.
3. Sync the Gradle files.
4. Run the app on an emulator or a physical device (API 24+).

