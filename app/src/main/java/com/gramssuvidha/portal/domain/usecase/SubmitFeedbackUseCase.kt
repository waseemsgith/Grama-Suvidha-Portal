package com.gramssuvidha.portal.domain.usecase

import com.gramssuvidha.portal.domain.model.Feedback
import com.gramssuvidha.portal.domain.repository.AIRepository
import com.gramssuvidha.portal.domain.repository.FeedbackRepository
import com.gramssuvidha.portal.utils.Resource
import javax.inject.Inject

/**
 * Use case that submits citizen feedback with AI issue categorization.
 */
class SubmitFeedbackUseCase @Inject constructor(
    private val feedbackRepository: FeedbackRepository,
    private val aiRepository: AIRepository
) {
    suspend operator fun invoke(feedback: Feedback): Resource<Unit> {
        // AI categorize the issue before saving
        val aiCategory = try {
            aiRepository.categorizeIssue(feedback.comment)
        } catch (e: Exception) {
            feedback.issueType.displayName
        }
        val enrichedFeedback = feedback.copy(aiCategory = aiCategory)
        return feedbackRepository.submitFeedback(enrichedFeedback)
    }
}
