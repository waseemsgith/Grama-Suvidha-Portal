package com.gramssuvidha.portal.ui.home

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectCategory
import com.gramssuvidha.portal.domain.model.ProjectStatus
import com.gramssuvidha.portal.ui.components.*
import com.gramssuvidha.portal.ui.theme.*
import com.gramssuvidha.portal.utils.formatBudget

/**
 * Home screen — the app's main "Digital Village Notice Board".
 */
@Composable
fun HomeScreen(
    onProjectClick: (String) -> Unit,
    onSettingsClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    // Show error in snackbar
    LaunchedEffect(uiState.errorMessage) {
        uiState.errorMessage?.let { msg ->
            snackbarHostState.showSnackbar(
                message = msg,
                actionLabel = "Dismiss",
                duration = SnackbarDuration.Short
            )
            viewModel.dismissError()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                // ── Header ────────────────────────────────────────────────────
                item {
                    HomeHeader(
                        panchayatName = uiState.panchayatName,
                        onSettingsClick = onSettingsClick
                    )
                }

                // ── AI Insight Banner ─────────────────────────────────────────
                if (uiState.villageInsight.isNotEmpty()) {
                    item {
                        InsightBanner(
                            insight = uiState.villageInsight,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(12.dp))
                    }
                }

                // ── Stats Row ─────────────────────────────────────────────────
                item {
                    StatsRow(
                        projects = uiState.projects,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(Modifier.height(16.dp))
                }

                // ── Search Bar ────────────────────────────────────────────────
                item {
                    SearchBar(
                        query = uiState.searchQuery,
                        onQueryChange = viewModel::onSearchQueryChange,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                }

                // ── Filter Chips ──────────────────────────────────────────────
                item {
                    FilterChipsRow(
                        selectedFilter = uiState.selectedFilter,
                        onFilterSelected = viewModel::onFilterSelected
                    )
                    Spacer(Modifier.height(8.dp))
                }

                // ── Section Title ─────────────────────────────────────────────
                item {
                    Text(
                        text = "Projects (${uiState.filteredProjects.size})",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }

                // ── Loading Skeletons ─────────────────────────────────────────
                if (uiState.isLoading && uiState.projects.isEmpty()) {
                    items(4) {
                        ShimmerProjectCard(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }

                // ── Empty State ───────────────────────────────────────────────
                if (!uiState.isLoading && uiState.filteredProjects.isEmpty()) {
                    item {
                        EmptyState(
                            title = if (uiState.searchQuery.isNotEmpty()) "No results found"
                            else "No projects yet",
                            subtitle = if (uiState.searchQuery.isNotEmpty())
                                "Try a different search term or clear filters"
                            else "Pull down to refresh project data"
                        )
                    }
                }

                // ── Project Cards ─────────────────────────────────────────────
                items(
                    items = uiState.filteredProjects,
                    key = { it.id }
                ) { project ->
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(tween(300)) + slideInVertically(
                            animationSpec = tween(300),
                            initialOffsetY = { it / 4 }
                        )
                    ) {
                        ProjectCard(
                            project = project,
                            onClick = { onProjectClick(project.id) },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }
    }
}

// ── Sub-Composables ────────────────────────────────────────────────────────────

@Composable
private fun HomeHeader(
    panchayatName: String,
    onSettingsClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(GradientStart, GradientEnd)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 28.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "ಗ್ರಾಮ ಸುವಿಧಾ",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "Grama Suvidha",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                IconButton(
                    onClick = onSettingsClick,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.15f))
                ) {
                    Icon(
                        Icons.Rounded.Settings,
                        contentDescription = "Settings",
                        tint = Color.White
                    )
                }
            }
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.8f),
                    modifier = Modifier.size(14.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = panchayatName,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
        }
    }
}

@Composable
private fun InsightBanner(insight: String, modifier: Modifier = Modifier) {
    AnimatedContent(
        targetState = insight,
        transitionSpec = {
            (fadeIn(tween(500)) + slideInVertically(tween(500))) togetherWith
                    (fadeOut(tween(300)) + slideOutVertically(tween(300)))
        },
        label = "insight"
    ) { text ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(GreenPrimary.copy(alpha = 0.08f))
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("💡", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.width(8.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
            )
        }
    }
}

@Composable
private fun StatsRow(projects: List<Project>, modifier: Modifier = Modifier) {
    val total     = projects.size
    val completed = projects.count { it.status == ProjectStatus.COMPLETED }
    val inProg    = projects.count { it.status == ProjectStatus.IN_PROGRESS }
    val delayed   = projects.count { it.status == ProjectStatus.DELAYED }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        StatCard("Total", total.toString(), GreenPrimary, Modifier.weight(1f))
        StatCard("Done", completed.toString(), StatusCompleted, Modifier.weight(1f))
        StatCard("Active", inProg.toString(), StatusInProgress, Modifier.weight(1f))
        StatCard("Delayed", delayed.toString(), StatusDelayed, Modifier.weight(1f))
    }
}

@Composable
private fun StatCard(label: String, value: String, color: Color, modifier: Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = color.copy(alpha = 0.10f)
        ),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = color
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = {
            Text(
                "Search projects, location…",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        leadingIcon = {
            Icon(Icons.Rounded.Search, contentDescription = "Search",
                tint = MaterialTheme.colorScheme.onSurfaceVariant)
        },
        trailingIcon = {
            AnimatedVisibility(query.isNotEmpty()) {
                IconButton(onClick = { onQueryChange("") }) {
                    Icon(Icons.Rounded.Clear, contentDescription = "Clear",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f),
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        )
    )
}

@Composable
private fun FilterChipsRow(
    selectedFilter: ProjectStatus?,
    onFilterSelected: (ProjectStatus?) -> Unit
) {
    val filters = listOf(
        null to "All",
        ProjectStatus.IN_PROGRESS to "In Progress",
        ProjectStatus.COMPLETED to "Completed",
        ProjectStatus.DELAYED to "Delayed",
        ProjectStatus.UPCOMING to "Upcoming"
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filters) { (status, label) ->
            FilterChip(
                selected = selectedFilter == status,
                onClick = { onFilterSelected(status) },
                label = { Text(label, style = MaterialTheme.typography.labelMedium) },
                shape = RoundedCornerShape(20.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProjectCard(
    project: Project,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Top row: Category + Status
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CategoryChip(project.category.displayName)
                StatusChip(project.status)
            }
            Spacer(Modifier.height(10.dp))

            // Title
            Text(
                text = project.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2
            )
            Spacer(Modifier.height(4.dp))

            // Location
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = "${project.ward} • ${project.location}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )
            }
            Spacer(Modifier.height(14.dp))

            // Progress bar
            AnimatedProgressBar(
                progress = project.progressPercent / 100f,
                height = 8.dp,
                progressColor = when (project.status) {
                    ProjectStatus.COMPLETED   -> StatusCompleted
                    ProjectStatus.DELAYED     -> StatusDelayed
                    ProjectStatus.UPCOMING    -> StatusUpcoming
                    else                      -> MaterialTheme.colorScheme.primary
                }
            )
            Spacer(Modifier.height(14.dp))

            // Stats row
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatItem("Budget", project.budget.formatBudget())
                StatItem("Spent", project.budgetSpent.formatBudget(),
                    valueColor = if (project.budgetSpent > project.budget * 0.85)
                        StatusDelayed else MaterialTheme.colorScheme.onSurface)
                StatItem("Expected", project.expectedCompletionDate)
            }

            // Arrow indicator
            Row(
                Modifier.fillMaxWidth().padding(top = 12.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    "View Details →",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
