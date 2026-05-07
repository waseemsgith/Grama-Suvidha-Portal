package com.gramssuvidha.portal.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.gramssuvidha.portal.ui.theme.GreenLight
import com.gramssuvidha.portal.ui.theme.GreenPrimary

/**
 * AI Summary card that shows a glowing, animated panel with the AI-generated summary.
 */
@Composable
fun AiSummaryCard(
    summary: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(
                Brush.linearGradient(
                    listOf(
                        GreenPrimary.copy(alpha = 0.08f),
                        GreenLight.copy(alpha = 0.04f)
                    )
                )
            )
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(
                    listOf(GreenPrimary.copy(alpha = 0.4f), GreenLight.copy(alpha = 0.2f))
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.AutoAwesome,
                    contentDescription = "AI",
                    tint = GreenPrimary,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = "AI Progress Insight",
                    style = MaterialTheme.typography.labelMedium,
                    color = GreenPrimary
                )
            }
            Spacer(Modifier.height(8.dp))
            AnimatedContent(
                targetState = isLoading,
                transitionSpec = { fadeIn() togetherWith fadeOut() },
                label = "aiContent"
            ) { loading ->
                if (loading) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        repeat(3) { idx ->
                            ShimmerLine(
                                widthFraction = if (idx == 2) 0.65f else 1f
                            )
                        }
                    }
                } else {
                    Text(
                        text = summary.ifEmpty { "Generating AI summary…" },
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
                    )
                }
            }
        }
    }
}

@Composable
private fun ShimmerLine(widthFraction: Float) {
    val infiniteTransition = rememberInfiniteTransition(label = "shimmer")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.7f,
        animationSpec = infiniteRepeatable(
            animation = tween(900, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )
    Box(
        modifier = Modifier
            .fillMaxWidth(widthFraction)
            .height(12.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(GreenPrimary.copy(alpha = alpha))
    )
}
