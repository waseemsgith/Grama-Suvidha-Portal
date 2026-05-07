package com.gramssuvidha.portal.ui.feedback

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gramssuvidha.portal.domain.model.IssueType
import com.gramssuvidha.portal.ui.theme.*

/**
 * Feedback screen — citizen form with star rating, issue type, and AI categorization.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackScreen(
    projectId: String,
    projectTitle: String,
    onBack: () -> Unit,
    viewModel: FeedbackViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    // Show success snackbar and navigate back
    LaunchedEffect(uiState.isSubmitted) {
        if (uiState.isSubmitted) {
            snackbarHostState.showSnackbar(
                message = "✅ Feedback submitted! Thank you for your contribution.",
                duration = SnackbarDuration.Short
            )
            onBack()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Citizen Feedback") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Rounded.ArrowBackIosNew, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Project info banner
            ProjectBanner(title = projectTitle)

            // Star Rating
            StarRatingSection(
                rating = uiState.rating,
                onRatingChange = viewModel::onRatingChange,
                error = uiState.ratingError
            )

            // Issue Type Selector
            IssueTypeSection(
                selected = uiState.selectedIssueType,
                onSelect = viewModel::onIssueTypeSelected
            )

            // Comment box with AI categorization
            CommentSection(
                comment = uiState.comment,
                onCommentChange = viewModel::onCommentChange,
                aiCategory = uiState.aiCategory,
                isAiCategorizing = uiState.isAiCategorizing,
                error = uiState.commentError
            )

            // Citizen info
            CitizenInfoSection(
                name = uiState.citizenName,
                contact = uiState.citizenContact,
                onNameChange = viewModel::onNameChange,
                onContactChange = viewModel::onContactChange,
                nameError = uiState.nameError
            )

            // Image upload placeholder
            ImageUploadPlaceholder()

            // Submit button
            Button(
                onClick = viewModel::submitFeedback,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                enabled = !uiState.isSubmitting,
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenPrimary
                )
            ) {
                if (uiState.isSubmitting) {
                    CircularProgressIndicator(
                        color = Color.White,
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(22.dp)
                    )
                } else {
                    Icon(Icons.Rounded.Send, contentDescription = null,
                        modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text(
                        "Submit Feedback",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
        }
    }
}

// ── Sub-Composables ────────────────────────────────────────────────────────────

@Composable
private fun ProjectBanner(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(GreenPrimary.copy(alpha = 0.08f))
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Rounded.AccountBalance, null,
            tint = GreenPrimary, modifier = Modifier.size(22.dp))
        Spacer(Modifier.width(10.dp))
        Column {
            Text("Giving feedback for:",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface)
        }
    }
}

@Composable
private fun StarRatingSection(
    rating: Int,
    onRatingChange: (Int) -> Unit,
    error: String?
) {
    FeedbackCard(title = "Your Rating") {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            (1..5).forEach { star ->
                IconButton(onClick = { onRatingChange(star) }) {
                    Icon(
                        imageVector = if (star <= rating)
                            Icons.Rounded.Star else Icons.Rounded.StarOutline,
                        contentDescription = "$star stars",
                        tint = if (star <= rating) SaffronAccent
                        else MaterialTheme.colorScheme.outline,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
        }
        val ratingLabel = when (rating) {
            1 -> "😞 Very Dissatisfied"
            2 -> "😕 Dissatisfied"
            3 -> "😐 Neutral"
            4 -> "🙂 Satisfied"
            5 -> "😊 Very Satisfied"
            else -> "Tap a star to rate"
        }
        Text(
            text = ratingLabel,
            style = MaterialTheme.typography.bodySmall,
            color = if (rating == 0) MaterialTheme.colorScheme.onSurfaceVariant
            else GreenPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        error?.let {
            Spacer(Modifier.height(4.dp))
            Text(it, style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.error)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun IssueTypeSection(
    selected: IssueType,
    onSelect: (IssueType) -> Unit
) {
    FeedbackCard(title = "Issue Type") {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IssueType.entries.forEach { issueType ->
                FilterChip(
                    selected = selected == issueType,
                    onClick = { onSelect(issueType) },
                    label = { Text(issueType.displayName,
                        style = MaterialTheme.typography.labelSmall) },
                    shape = RoundedCornerShape(20.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = GreenPrimary,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }
    }
}

@Composable
private fun CommentSection(
    comment: String,
    onCommentChange: (String) -> Unit,
    aiCategory: String,
    isAiCategorizing: Boolean,
    error: String?
) {
    FeedbackCard(title = "Your Comments") {
        OutlinedTextField(
            value = comment,
            onValueChange = onCommentChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            placeholder = {
                Text("Describe your experience, concern, or suggestion…",
                    style = MaterialTheme.typography.bodyMedium)
            },
            shape = RoundedCornerShape(12.dp),
            isError = error != null
        )
        error?.let {
            Text(it, style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.error)
        }
        // AI category chip
        AnimatedVisibility(
            visible = aiCategory.isNotEmpty() || isAiCategorizing,
            enter = fadeIn() + expandVertically()
        ) {
            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Rounded.AutoAwesome, null,
                    tint = GreenPrimary, modifier = Modifier.size(14.dp))
                Spacer(Modifier.width(4.dp))
                Text("AI categorized: ", style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                if (isAiCategorizing) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(12.dp),
                        strokeWidth = 1.5.dp,
                        color = GreenPrimary
                    )
                } else {
                    Text(aiCategory, style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold, color = GreenPrimary)
                }
            }
        }
    }
}

@Composable
private fun CitizenInfoSection(
    name: String,
    contact: String,
    onNameChange: (String) -> Unit,
    onContactChange: (String) -> Unit,
    nameError: String?
) {
    FeedbackCard(title = "Your Information") {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Full Name *") },
            leadingIcon = { Icon(Icons.Rounded.Person, null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            isError = nameError != null,
            supportingText = nameError?.let { { Text(it) } }
        )
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = contact,
            onValueChange = onContactChange,
            label = { Text("Phone / WhatsApp (optional)") },
            leadingIcon = { Icon(Icons.Rounded.Phone, null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(6.dp))
        Text(
            "Your information is kept confidential and used only for follow-up.",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ImageUploadPlaceholder() {
    FeedbackCard(title = "Attach Photo (Optional)") {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 1.5.dp,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(12.dp)
                )
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Rounded.AddPhotoAlternate, null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.width(8.dp))
                Text("Tap to upload issue photo",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Composable
private fun FeedbackCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(12.dp))
            content()
        }
    }
}
