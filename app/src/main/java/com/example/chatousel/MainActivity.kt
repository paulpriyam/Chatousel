package com.example.chatousel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.chatousel.ui.chat.ChatScreen
import com.example.chatousel.ui.theme.ChatouselTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatouselTheme {
                ChatScreen()
            }
        }
    }
}