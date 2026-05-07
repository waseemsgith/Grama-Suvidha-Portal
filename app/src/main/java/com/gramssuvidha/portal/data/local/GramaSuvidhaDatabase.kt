package com.gramssuvidha.portal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gramssuvidha.portal.data.local.converter.StringListConverter
import com.gramssuvidha.portal.data.local.dao.FeedbackDao
import com.gramssuvidha.portal.data.local.dao.ProjectDao
import com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao
import com.gramssuvidha.portal.data.local.entity.FeedbackEntity
import com.gramssuvidha.portal.data.local.entity.ProjectEntity
import com.gramssuvidha.portal.data.local.entity.ProjectUpdateEntity

/**
 * Main Room database for Grama Suvidha app.
 * Contains projects, feedback, and project updates tables.
 */
@Database(
    entities = [
        ProjectEntity::class,
        FeedbackEntity::class,
        ProjectUpdateEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(StringListConverter::class)
abstract class GramaSuvidhaDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao
    abstract fun feedbackDao(): FeedbackDao
    abstract fun projectUpdateDao(): ProjectUpdateDao

    companion object {
        const val DATABASE_NAME = "grama_suvidha_db"
    }
}
