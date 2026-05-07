package com.gramssuvidha.portal.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * DTO representing a feedback submission payload.
 */
data class FeedbackDto(
    @SerializedName("id") val id: String,
    @SerializedName("project_id") val projectId: String,
    @SerializedName("project_title") val projectTitle: String,
    @SerializedName("rating") val rating: Int,
    @SerializedName("comment") val comment: String,
    @SerializedName("issue_type") val issueType: String,
    @SerializedName("citizen_name") val citizenName: String,
    @SerializedName("citizen_contact") val citizenContact: String,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("submitted_at") val submittedAt: Long
)

data class FeedbackResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String
)

/**
 * DTO for a project timeline update from the API.
 */
data class ProjectUpdateDto(
    @SerializedName("id") val id: String,
    @SerializedName("project_id") val projectId: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("progress_percent") val progressPercent: Int,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("updated_by") val updatedBy: String,
    @SerializedName("updated_at") val updatedAt: Long
)

data class ProjectUpdatesResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<ProjectUpdateDto>
)
