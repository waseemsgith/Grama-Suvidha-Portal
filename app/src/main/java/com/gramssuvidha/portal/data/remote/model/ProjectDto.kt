package com.gramssuvidha.portal.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * DTO representing a project returned from the API.
 */
data class ProjectDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String,
    @SerializedName("status") val status: String,
    @SerializedName("budget") val budget: Double,
    @SerializedName("budget_spent") val budgetSpent: Double,
    @SerializedName("progress_percent") val progressPercent: Int,
    @SerializedName("contractor") val contractor: String,
    @SerializedName("contractor_contact") val contractorContact: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("expected_completion") val expectedCompletionDate: String,
    @SerializedName("actual_completion") val actualCompletionDate: String?,
    @SerializedName("location") val location: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("ward") val ward: String,
    @SerializedName("panchayat_name") val panchayatName: String,
    @SerializedName("image_urls") val imageUrls: List<String>,
    @SerializedName("before_images") val beforeImages: List<String>,
    @SerializedName("after_images") val afterImages: List<String>,
    @SerializedName("ai_summary") val aiSummary: String,
    @SerializedName("last_updated") val lastUpdated: Long
)

data class ProjectsResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<ProjectDto>,
    @SerializedName("total") val total: Int
)
