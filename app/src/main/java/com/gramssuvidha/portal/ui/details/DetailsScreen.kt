package com.gramssuvidha.portal.ui.details

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectStatus
import com.gramssuvidha.portal.domain.model.ProjectUpdate
import com.gramssuvidha.portal.ui.components.*
import com.gramssuvidha.portal.ui.theme.*
import com.gramssuvidha.portal.utils.formatBudget
import com.gramssuvidha.portal.utils.toReadableDate

/**
 * Project Details screen — full project dashboard with timeline and AI insight.
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DetailsScreen(
    projectId: String,
    onBack: () -> Unit,
    onFeedbackClick: (String, String) -> Unit,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = uiState.project?.title ?: "Project Details",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
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
        floatingActionButton = {
            uiState.project?.let { project ->
                ExtendedFloatingActionButton(
                    onClick = { onFeedbackClick(project.id, project.title) },
                    icon = { Icon(Icons.Rounded.RateReview, "Feedback") },
                    text = { Text("Give Feedback") },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        when {
            uiState.isLoading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                }
            }
            uiState.errorMessage != null -> {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    ErrorState(
                        message = uiState.errorMessage!!,
                        onRetry = { }
                    )
                }
            }
            uiState.project != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 96.dp)
                ) {
                    val project = uiState.project!!
                    ProjectDetailContent(
                        project = project,
                        updates = uiState.updates,
                        aiSummary = uiState.aiSummary,
                        isAiLoading = uiState.isAiLoading
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ProjectDetailContent(
    project: Project,
    updates: List<ProjectUpdate>,
    aiSummary: String,
    isAiLoading: Boolean
) {
    // ── Status + Progress Hero ─────────────────────────────────────────────────
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(listOf(GradientStart, GradientEnd))
            )
            .padding(20.dp)
    ) {
        Column {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CategoryChip(project.category.displayName)
                StatusChip(project.status)
            }
            Spacer(Modifier.height(16.dp))
            Text(
                text = project.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Rounded.LocationOn, null,
                    tint = Color.White.copy(0.8f),
                    modifier = Modifier.size(14.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "${project.ward} · ${project.panchayatName}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(0.8f)
                )
            }
            Spacer(Modifier.height(20.dp))

            // Big progress bar
            Column {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Progress", style = MaterialTheme.typography.labelMedium,
                        color = Color.White.copy(0.8f))
                    Text(
                        "${project.progressPercent}%",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Spacer(Modifier.height(6.dp))
                LinearProgressIndicator(
                    progress = { project.progressPercent / 100f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    color = Color.White,
                    trackColor = Color.White.copy(alpha = 0.3f)
                )
            }
        }
    }

    Spacer(Modifier.height(16.dp))

    // ── Budget Cards ───────────────────────────────────────────────────────────
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BudgetCard(
            label = "Total Budget",
            amount = project.budget.formatBudget(),
            icon = "💰",
            color = GreenPrimary,
            modifier = Modifier.weight(1f)
        )
        BudgetCard(
            label = "Amount Spent",
            amount = project.budgetSpent.formatBudget(),
            icon = "📊",
            color = if (project.budgetSpent > project.budget * 0.85)
                StatusDelayed else StatusInProgress,
            modifier = Modifier.weight(1f)
        )
    }

    Spacer(Modifier.height(16.dp))

    // ── AI Summary ─────────────────────────────────────────────────────────────
    AiSummaryCard(
        summary = aiSummary,
        isLoading = isAiLoading,
        modifier = Modifier.padding(horizontal = 16.dp)
    )

    Spacer(Modifier.height(16.dp))

    // ── Description ────────────────────────────────────────────────────────────
    SectionCard(title = "About This Project") {
        Text(
            text = project.description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
        )
    }

    Spacer(Modifier.height(12.dp))

    // ── Image Gallery ──────────────────────────────────────────────────────────
    val allImages = (project.beforeImages + project.afterImages + project.imageUrls).distinct()
    if (allImages.isNotEmpty()) {
        SectionCard(title = "Project Gallery (${allImages.size} photos)") {
            val pagerState = rememberPagerState { allImages.size }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) { page ->
                AsyncImage(
                    model = allImages[page],
                    contentDescription = "Project image ${page + 1}",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            if (allImages.size > 1) {
                Spacer(Modifier.height(8.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(allImages.size) { idx ->
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .size(if (pagerState.currentPage == idx) 8.dp else 5.dp)
                                .clip(CircleShape)
                                .background(
                                    if (pagerState.currentPage == idx)
                                        MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)
                                )
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(12.dp))
    }

    // ── Contractor Info ────────────────────────────────────────────────────────
    SectionCard(title = "Contractor & Timeline") {
        InfoRow("Contractor", project.contractor, Icons.Rounded.Engineering)
        Spacer(Modifier.height(8.dp))
        InfoRow("Contact", project.contractorContact, Icons.Rounded.Phone)
        Spacer(Modifier.height(8.dp))
        InfoRow("Start Date", project.startDate, Icons.Rounded.PlayArrow)
        Spacer(Modifier.height(8.dp))
        InfoRow(
            "Expected Completion",
            project.expectedCompletionDate,
            Icons.Rounded.Event,
            valueColor = if (project.status == ProjectStatus.DELAYED)
                StatusDelayed else MaterialTheme.colorScheme.onSurface
        )
        project.actualCompletionDate?.let { date ->
            Spacer(Modifier.height(8.dp))
            InfoRow("Completed On", date, Icons.Rounded.CheckCircle,
                valueColor = StatusCompleted)
        }
    }

    Spacer(Modifier.height(12.dp))

    // ── Location ───────────────────────────────────────────────────────────────
    SectionCard(title = "Location") {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Rounded.LocationOn, null,
                tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(18.dp))
            Spacer(Modifier.width(8.dp))
            Text(
                text = project.location,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(Modifier.height(8.dp))
        // Map placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Rounded.Map, null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(36.dp))
                Spacer(Modifier.height(4.dp))
                Text(
                    "Map: ${project.latitude}, ${project.longitude}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

    Spacer(Modifier.height(12.dp))

    // ── Timeline Updates ───────────────────────────────────────────────────────
    if (updates.isNotEmpty()) {
        SectionCard(title = "Project Timeline") {
            updates.forEachIndexed { idx, update ->
                TimelineItem(update = update, isLast = idx == updates.size - 1)
            }
        }
        Spacer(Modifier.height(12.dp))
    }
}

// ── Private helpers ────────────────────────────────────────────────────────────

@Composable
private fun SectionCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.height(12.dp))
            content()
        }
    }
}

@Composable
private fun BudgetCard(
    label: String, amount: String, icon: String,
    color: Color, modifier: Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.08f)),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(icon, style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(4.dp))
            Text(amount, style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold, color = color)
            Text(label, style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    valueColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Row(verticalAlignment = Alignment.Top) {
        Icon(icon, null, tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(16.dp).padding(top = 2.dp))
        Spacer(Modifier.width(8.dp))
        Column {
            Text(label, style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(value, style = MaterialTheme.typography.bodyMedium, color = valueColor)
        }
    }
}

@Composable
private fun TimelineItem(update: ProjectUpdate, isLast: Boolean) {
    Row(modifier = Modifier.fillMaxWidth()) {
        // Timeline indicator
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(GreenPrimary)
            )
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(60.dp)
                        .background(GreenPrimary.copy(alpha = 0.3f))
                )
            }
        }
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.padding(bottom = if (isLast) 0.dp else 8.dp)) {
            Text(update.title, style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(2.dp))
            Text(update.description, style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("${update.progressPercent}% complete",
                    style = MaterialTheme.typography.labelSmall,
                    color = GreenPrimary)
                Text(update.updatedAt.toReadableDate(),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
