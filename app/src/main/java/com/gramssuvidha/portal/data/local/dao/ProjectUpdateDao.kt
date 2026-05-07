package com.gramssuvidha.portal.data.local.dao

import androidx.room.*
import com.gramssuvidha.portal.data.local.entity.ProjectUpdateEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO for project timeline update operations.
 */
@Dao
interface ProjectUpdateDao {

    @Query("SELECT * FROM project_updates WHERE projectId = :projectId ORDER BY updatedAt DESC")
    fun getUpdatesForProject(projectId: String): Flow<List<ProjectUpdateEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdates(updates: List<ProjectUpdateEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdate(update: ProjectUpdateEntity)

    @Query("DELETE FROM project_updates WHERE projectId = :projectId")
    suspend fun deleteUpdatesForProject(projectId: String)
}
