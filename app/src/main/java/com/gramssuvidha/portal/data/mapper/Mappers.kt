package com.gramssuvidha.portal.data.mapper

import com.gramssuvidha.portal.data.local.entity.FeedbackEntity
import com.gramssuvidha.portal.data.local.entity.ProjectEntity
import com.gramssuvidha.portal.data.local.entity.ProjectUpdateEntity
import com.gramssuvidha.portal.data.remote.model.FeedbackDto
import com.gramssuvidha.portal.data.remote.model.ProjectDto
import com.gramssuvidha.portal.data.remote.model.ProjectUpdateDto
import com.gramssuvidha.portal.domain.model.Feedback
import com.gramssuvidha.portal.domain.model.IssueType
import com.gramssuvidha.portal.domain.model.Project
import com.gramssuvidha.portal.domain.model.ProjectCategory
import com.gramssuvidha.portal.domain.model.ProjectStatus
import com.gramssuvidha.portal.domain.model.ProjectUpdate

// ────────────────────────────────────────────────
// ProjectDto → ProjectEntity (remote → local cache)
// ────────────────────────────────────────────────
fun ProjectDto.toEntity(): ProjectEntity = ProjectEntity(
    id = id, title = title, description = description,
    category = category, status = status,
    budget = budget, budgetSpent = budgetSpent,
    progressPercent = progressPercent,
    contractor = contractor, contractorContact = contractorContact,
    startDate = startDate, expectedCompletionDate = expectedCompletionDate,
    actualCompletionDate = actualCompletionDate,
    location = location, latitude = latitude, longitude = longitude,
    ward = ward, panchayatName = panchayatName,
    imageUrls = imageUrls, beforeImages = beforeImages, afterImages = afterImages,
    aiSummary = aiSummary, lastUpdated = lastUpdated
)

// ────────────────────────────────────────────────
// ProjectEntity → Project (local cache → domain)
// ────────────────────────────────────────────────
fun ProjectEntity.toDomain(): Project = Project(
    id = id, title = title, description = description,
    category = runCatching { ProjectCategory.valueOf(category) }.getOrDefault(ProjectCategory.COMMUNITY),
    status = runCatching { ProjectStatus.valueOf(status) }.getOrDefault(ProjectStatus.UPCOMING),
    budget = budget, budgetSpent = budgetSpent,
    progressPercent = progressPercent,
    contractor = contractor, contractorContact = contractorContact,
    startDate = startDate, expectedCompletionDate = expectedCompletionDate,
    actualCompletionDate = actualCompletionDate,
    location = location, latitude = latitude, longitude = longitude,
    ward = ward, panchayatName = panchayatName,
    imageUrls = imageUrls, beforeImages = beforeImages, afterImages = afterImages,
    aiSummary = aiSummary, lastUpdated = lastUpdated
)

// ────────────────────────────────────────────────
// ProjectUpdateDto → ProjectUpdateEntity → ProjectUpdate
// ────────────────────────────────────────────────
fun ProjectUpdateDto.toEntity(): ProjectUpdateEntity = ProjectUpdateEntity(
    id = id, projectId = projectId, title = title,
    description = description, progressPercent = progressPercent,
    imageUrl = imageUrl, updatedBy = updatedBy, updatedAt = updatedAt
)

fun ProjectUpdateEntity.toDomain(): ProjectUpdate = ProjectUpdate(
    id = id, projectId = projectId, title = title,
    description = description, progressPercent = progressPercent,
    imageUrl = imageUrl, updatedBy = updatedBy, updatedAt = updatedAt
)

// ────────────────────────────────────────────────
// Feedback domain → FeedbackEntity (for local storage)
// ────────────────────────────────────────────────
fun Feedback.toEntity(): FeedbackEntity = FeedbackEntity(
    id = id, projectId = projectId, projectTitle = projectTitle,
    rating = rating, comment = comment,
    issueType = issueType.name,
    citizenName = citizenName, citizenContact = citizenContact,
    imageUrl = imageUrl, isSubmitted = isSubmitted,
    submittedAt = submittedAt, aiCategory = aiCategory
)

fun FeedbackEntity.toDomain(): Feedback = Feedback(
    id = id, projectId = projectId, projectTitle = projectTitle,
    rating = rating, comment = comment,
    issueType = runCatching { IssueType.valueOf(issueType) }.getOrDefault(IssueType.GENERAL),
    citizenName = citizenName, citizenContact = citizenContact,
    imageUrl = imageUrl, isSubmitted = isSubmitted,
    submittedAt = submittedAt, aiCategory = aiCategory
)

// ────────────────────────────────────────────────
// Feedback domain → FeedbackDto (for API submission)
// ────────────────────────────────────────────────
fun Feedback.toDto(): FeedbackDto = FeedbackDto(
    id = id, projectId = projectId, projectTitle = projectTitle,
    rating = rating, comment = comment,
    issueType = issueType.name,
    citizenName = citizenName, citizenContact = citizenContact,
    imageUrl = imageUrl, submittedAt = submittedAt
)
