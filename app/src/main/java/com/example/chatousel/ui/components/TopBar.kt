package com.example.chatousel.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chatousel.model.Contact
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.equalColors

@Composable
fun TopBar(
    contact: Contact,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onCallClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.equalColors.appBar),
    ) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = onBackClick,
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back",
                    tint = MaterialTheme.equalColors.primaryText,
                )
            }
            Image(
                painter = painterResource(contact.avatarRes),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = contact.name,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.equalColors.primaryText,
                    maxLines = 1,
                )
                Text(
                    text = contact.phone,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.equalColors.primaryText,
                    maxLines = 1,
                )
            }
            IconButton(onClick = onCallClick) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = MaterialTheme.equalColors.primaryText,
                )
            }
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options",
                    tint = MaterialTheme.equalColors.primaryText,
                )
            }
        }
    }
}

@EqualPreview
@Composable
fun TopBarPreview() {
    ChatouselTheme {
        TopBar(
            contact = Contact(
                name = "Amazon",
                phone = "+912268910001",
                avatarRes = com.example.chatousel.R.drawable.avatar,
            ),
        )
    }
}
