package com.example.chatousel.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.chatousel.model.CarouselCard
import com.example.chatousel.ui.preview.EqualPreview
import com.example.chatousel.ui.theme.ChatouselTheme
import com.example.chatousel.ui.theme.equalColors

@Composable
fun PollCard(
    card: CarouselCard.Poll,
    selectedOption: String?,
    onOptionSelected: (CarouselCard.Poll, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.equalColors.incomingBubble,
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = card.question,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.equalColors.primaryText,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Select one or more",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.equalColors.secondaryText,
                )
            }

            val totalVotes = card.votes.values.sum().coerceAtLeast(1)

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                card.options.forEach { option ->
                    val voteCount = card.votes[option] ?: 0
                    val progress = voteCount.toFloat() / totalVotes
                    PollOption(
                        option = option,
                        selected = option == selectedOption,
                        voteCount = voteCount,
                        progress = progress,
                        onClick = { onOptionSelected(card, option) },
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(top = 8.dp),
                color = MaterialTheme.equalColors.secondaryText.copy(alpha = 0.1f)
            )

            TextButton(
                onClick = { /* TODO */ },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "View votes",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.equalColors.actionGreen,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun PollOption(
    option: String,
    selected: Boolean,
    voteCount: Int,
    progress: Float,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                role = Role.RadioButton,
                onClick = onClick,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = if (selected) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
            contentDescription = null,
            tint = if (selected) MaterialTheme.equalColors.actionGreen else MaterialTheme.equalColors.secondaryText.copy(alpha = 0.5f),
            modifier = Modifier.size(24.dp)
        )

        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = option,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.equalColors.primaryText,
                )
                Text(
                    text = voteCount.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.equalColors.secondaryText,
                )
            }
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = MaterialTheme.equalColors.actionGreen,
                trackColor = MaterialTheme.equalColors.secondaryText.copy(alpha = 0.1f),
                strokeCap = StrokeCap.Round
            )
        }
    }
}

@EqualPreview
@Composable
private fun PollCardPreview() {
    ChatouselTheme {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // Selected state
            PollCard(
                card = CarouselCard.Poll(
                    id = "poll-1",
                    question = "Time to vote on the dessert – you can only pick one!",
                    options = listOf("Gulab Jamun", "Rasgulla", "Pantua"),
                    votes = mapOf("Gulab Jamun" to 10, "Rasgulla" to 12, "Pantua" to 3)
                ),
                selectedOption = "Gulab Jamun",
                onOptionSelected = { _, _ -> }
            )

            // Initial/Unselected state
            PollCard(
                card = CarouselCard.Poll(
                    id = "poll-2",
                    question = "Who do you think is gonna win the IPL this time??",
                    options = listOf("Rajasthan Royals", "Chennai Super Kings", "Mumbai Indians", "Kolkata Knight Riders", "RCB", "Sunrisers Hyderabad", "Delhi Capitals"),
                    votes = mapOf("Rajasthan Royals" to 0, "Chennai Super Kings" to 0, "Mumbai Indians" to 0, "Kolkata Knight Riders" to 0, "RCB" to 0,"Sunrisers Hyderabad" to 0, "Delhi Capitals" to 0)
                ),
                selectedOption = null,
                onOptionSelected = { _, _ -> }
            )
        }
    }
}
