package com.gramssuvidha.portal.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room entity representing a citizen feedback entry (offline-first).
 */
@Entity(tableName = "feedback")
data class FeedbackEntity(
    @PrimaryKey val id: String,
    val projectId: String,
    val projectTitle: String,
    val rating: Int,
    val comment: String,
    val issueType: String,
    val citizenName: String,
    val citizenContact: String,
    val imageUrl: String?,
    val isSubmitted: Boolean,
    val submittedAt: Long,
    val aiCategory: String
)
