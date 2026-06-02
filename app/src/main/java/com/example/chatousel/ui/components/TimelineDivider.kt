package com.example.chatousel.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.chatousel.ui.theme.equalColors

@Composable
fun TimelineDivider(
    label: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = label,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.equalColors.dividerText,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        textAlign = TextAlign.Center,
    )
}