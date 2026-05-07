package com.gramssuvidha.portal.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.gramssuvidha.portal.data.local.converter.StringListConverter

/**
 * Room entity representing a cached Panchayat project.
 */
@Entity(tableName = "projects")
@TypeConverters(StringListConverter::class)
data class ProjectEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val category: String,
    val status: String,
    val budget: Double,
    val budgetSpent: Double,
    val progressPercent: Int,
    val contractor: String,
    val contractorContact: String,
    val startDate: String,
    val expectedCompletionDate: String,
    val actualCompletionDate: String?,
    val location: String,
    val latitude: Double,
    val longitude: Double,
    val ward: String,
    val panchayatName: String,
    val imageUrls: List<String>,
    val beforeImages: List<String>,
    val afterImages: List<String>,
    val aiSummary: String,
    val lastUpdated: Long
)
