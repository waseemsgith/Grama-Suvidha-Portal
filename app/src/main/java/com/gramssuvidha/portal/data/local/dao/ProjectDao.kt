package com.gramssuvidha.portal.data.local.dao

import androidx.room.*
import com.gramssuvidha.portal.data.local.entity.ProjectEntity
import kotlinx.coroutines.flow.Flow

/**
 * DAO for project-related database operations.
 */
@Dao
interface ProjectDao {

    @Query("SELECT * FROM projects ORDER BY lastUpdated DESC")
    fun getAllProjects(): Flow<List<ProjectEntity>>

    @Query("SELECT * FROM projects WHERE id = :id LIMIT 1")
    fun getProjectById(id: String): Flow<ProjectEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProjects(projects: List<ProjectEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProject(project: ProjectEntity)

    @Delete
    suspend fun deleteProject(project: ProjectEntity)

    @Query("DELETE FROM projects")
    suspend fun deleteAllProjects()

    @Query("SELECT COUNT(*) FROM projects")
    suspend fun getProjectCount(): Int
}
