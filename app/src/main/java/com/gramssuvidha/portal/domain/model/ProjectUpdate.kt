package com.gramssuvidha.portal.domain.model

/**
 * Domain model representing a timeline update entry for a project.
 */
data class ProjectUpdate(
    val id: String,
    val projectId: String,
    val title: String,
    val description: String,
    val progressPercent: Int,
    val imageUrl: String?,
    val updatedBy: String,
    val updatedAt: Long
)
