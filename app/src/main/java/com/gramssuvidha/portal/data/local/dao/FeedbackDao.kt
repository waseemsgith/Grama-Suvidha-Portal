package com.gramssuvidha.portal.data.local.dao

import androidx.room.*
import com.gramssuvidha.portal.data.local.entity.FeedbackEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO for feedback-related database operations.
 */
@Dao
interface FeedbackDao {

    @Query("SELECT * FROM feedback WHERE projectId = :projectId ORDER BY submittedAt DESC")
    fun getFeedbackForProject(projectId: String): Flow<List<FeedbackEntity>>

    @Query("SELECT * FROM feedback WHERE isSubmitted = 0")
    suspend fun getPendingFeedback(): List<FeedbackEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeedback(feedback: FeedbackEntity)

    @Update
    suspend fun updateFeedback(feedback: FeedbackEntity)

    @Query("UPDATE feedback SET isSubmitted = 1 WHERE id = :id")
    suspend fun markAsSubmitted(id: String)

    @Delete
    suspend fun deleteFeedback(feedback: FeedbackEntity)
}
