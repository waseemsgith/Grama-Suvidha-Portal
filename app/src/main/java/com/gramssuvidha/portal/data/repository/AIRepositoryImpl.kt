package com.gramssuvidha.portal.data.repository

import com.gramssuvidha.portal.domain.repository.AIRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Fake/simulated AI Repository.
 * In production, replace with Gemini API or Vertex AI calls.
 */
@Singleton
class AIRepositoryImpl @Inject constructor() : AIRepository {

    override suspend fun generateProgressSummary(
        projectTitle: String,
        progress: Int,
        status: String
    ): String {
        delay(800) // Simulate AI latency
        return buildProgressSummary(projectTitle, progress, status)
    }

    override suspend fun categorizeIssue(issueText: String): String {
        delay(400) // Simulate AI latency
        val lower = issueText.lowercase()
        return when {
            lower.contains("corrupt") || lower.contains("bribe") || lower.contains("money") ->
                "⚠️ Corruption Concern"
            lower.contains("quality") || lower.contains("poor") || lower.contains("bad") ->
                "🔨 Quality Issue"
            lower.contains("delay") || lower.contains("slow") || lower.contains("late") ->
                "⏰ Timeline Delay"
            lower.contains("danger") || lower.contains("safe") || lower.contains("hazard") ->
                "🚨 Safety Hazard"
            lower.contains("incomplete") || lower.contains("unfinished") ->
                "🚧 Incomplete Work"
            lower.contains("good") || lower.contains("great") || lower.contains("excellent") ->
                "✅ Positive Appreciation"
            else -> "📋 General Feedback"
        }
    }

    override fun getVillageInsights(): Flow<String> = flow {
        val insights = listOf(
            "💡 62% of ongoing projects are on schedule this quarter.",
            "🌱 The pond rejuvenation project improved groundwater by 35% in Ward 1.",
            "🏫 School renovation will benefit 340+ students when completed in November.",
            "💡 Solar street lights have reduced road incidents by an estimated 40%.",
            "🚰 Safe drinking water now reaches 520 households via the RO plant.",
            "🏘️ 13 of 25 PM Awas homes are at roof level — on track for September.",
            "⚠️ The drainage project is 47 days delayed — review scheduled this week.",
            "🌾 Farmers' market project will save ₹15,000/season per farmer after completion."
        )
        insights.forEach { insight ->
            emit(insight)
            delay(3500) // Rotate insights every 3.5 seconds
        }
    }

    // ─── Private helpers ──────────────────────────────────────────────────────

    private fun buildProgressSummary(title: String, progress: Int, status: String): String {
        return when {
            progress == 100 -> "✅ '$title' has been successfully completed. " +
                    "Final inspections are done and the facility is now serving the community."

            status == "DELAYED" -> "⚠️ '$title' is currently delayed. Progress stands at $progress%. " +
                    "The Panchayat is actively monitoring this project and working with the " +
                    "contractor to expedite pending work."

            progress >= 75 -> "🎯 '$title' is in the final stretch at $progress% completion. " +
                    "Finishing work and quality checks are underway. " +
                    "Expected to be ready for public use very soon."

            progress >= 50 -> "🔨 '$title' is progressing well at $progress%. " +
                    "The project is on schedule. Major structural work is complete " +
                    "and the team is moving into the finishing phase."

            progress >= 25 -> "'$title' is at $progress% completion. " +
                    "Foundational work is complete and primary construction is underway. " +
                    "The project is progressing steadily as per the approved plan."

            progress > 0 -> "🚧 '$title' has just commenced with $progress% work done. " +
                    "Site preparation and initial groundwork are complete. " +
                    "Full-scale work is expected to begin shortly."

            else -> "📋 '$title' is approved and scheduled to begin soon. " +
                    "Tender process is complete and the contractor has been finalized."
        }
    }
}
