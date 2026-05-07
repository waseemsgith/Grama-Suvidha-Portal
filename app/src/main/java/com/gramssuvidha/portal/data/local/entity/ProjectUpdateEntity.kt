package com.gramssuvidha.portal.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room entity representing a timeline update for a project.
 */
@Entity(tableName = "project_updates")
data class ProjectUpdateEntity(
    @PrimaryKey val id: String,
    val projectId: String,
    val title: String,
    val description: String,
    val progressPercent: Int,
    val imageUrl: String?,
    val updatedBy: String,
    val updatedAt: Long
)
