package com.example.chatousel.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chatousel.ui.theme.spacing12
import com.example.chatousel.ui.theme.spacing24

@Composable
fun TimelineRow(
    avatar: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    trailing: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = spacing24, vertical = spacing12),
        verticalAlignment = Alignment.Top,
    ) {
        avatar()
        Spacer(Modifier.width(spacing12))
        Box(modifier = Modifier.weight(1f)) {
            content()
        }
        trailing?.let {
            Spacer(Modifier.width(spacing12))
            Box(
                modifier = Modifier.padding(top = 168.dp),
                contentAlignment = Alignment.Center,
            ) {
                it()
            }
        }
    }
}