package com.gramssuvidha.portal.domain.model

/**
 * Domain model representing a citizen feedback submission.
 */
data class Feedback(
    val id: String,
    val projectId: String,
    val projectTitle: String,
    val rating: Int,           // 1–5
    val comment: String,
    val issueType: IssueType,
    val citizenName: String,
    val citizenContact: String,
    val imageUrl: String?,
    val isSubmitted: Boolean,  // false = pending sync
    val submittedAt: Long,
    val aiCategory: String     // AI-categorized issue label
)

enum class IssueType(val displayName: String) {
    QUALITY("Quality Issue"),
    DELAY("Delay Concern"),
    CORRUPTION("Corruption Report"),
    SAFETY("Safety Hazard"),
    INCOMPLETE("Incomplete Work"),
    GENERAL("General Feedback"),
    APPRECIATION("Appreciation")
}
