package com.gramssuvidha.portal.domain.model

/**
 * Domain model representing a Panchayat infrastructure project.
 */
data class Project(
    val id: String,
    val title: String,
    val description: String,
    val category: ProjectCategory,
    val status: ProjectStatus,
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

enum class ProjectCategory(val displayName: String, val kannadaName: String) {
    ROAD("Road Development", "ರಸ್ತೆ ಅಭಿವೃದ್ಧಿ"),
    WATER("Water Supply", "ನೀರು ಸರಬರಾಜು"),
    EDUCATION("Education", "ಶಿಕ್ಷಣ"),
    HEALTH("Healthcare", "ಆರೋಗ್ಯ"),
    SANITATION("Sanitation", "ನೈರ್ಮಲ್ಯ"),
    ELECTRICITY("Electricity", "ವಿದ್ಯುತ್"),
    AGRICULTURE("Agriculture", "ಕೃಷಿ"),
    COMMUNITY("Community", "ಸಮುದಾಯ"),
    ENVIRONMENT("Environment", "ಪರಿಸರ"),
    HOUSING("Housing", "ವಸತಿ")
}

enum class ProjectStatus(val displayName: String, val kannadaName: String) {
    UPCOMING("Upcoming", "ಮುಂಬರುವ"),
    IN_PROGRESS("In Progress", "ಪ್ರಗತಿಯಲ್ಲಿ"),
    COMPLETED("Completed", "ಪೂರ್ಣಗೊಂಡಿದೆ"),
    DELAYED("Delayed", "ವಿಳಂಬವಾಗಿದೆ"),
    ON_HOLD("On Hold", "ತಡೆಹಿಡಿಯಲಾಗಿದೆ")
}
