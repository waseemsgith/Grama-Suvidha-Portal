package com.gramssuvidha.portal.domain.repository

import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for AI-powered features.
 */
interface AIRepository {
    /** Generate a human-readable progress summary for a project */
    suspend fun generateProgressSummary(projectTitle: String, progress: Int, status: String): String

    /** Categorize a citizen-submitted issue */
    suspend fun categorizeIssue(issueText: String): String

    /** Generate village-wide smart insights */
    fun getVillageInsights(): Flow<String>
}
