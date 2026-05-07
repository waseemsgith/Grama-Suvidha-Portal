package com.gramssuvidha.portal.di

import android.content.Context
import androidx.room.Room
import com.gramssuvidha.portal.data.local.GramaSuvidhaDatabase
import com.gramssuvidha.portal.data.local.dao.FeedbackDao
import com.gramssuvidha.portal.data.local.dao.ProjectDao
import com.gramssuvidha.portal.data.local.dao.ProjectUpdateDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module providing Room database and DAOs.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): GramaSuvidhaDatabase =
        Room.databaseBuilder(
            context,
            GramaSuvidhaDatabase::class.java,
            GramaSuvidhaDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideProjectDao(db: GramaSuvidhaDatabase): ProjectDao = db.projectDao()

    @Provides
    fun provideFeedbackDao(db: GramaSuvidhaDatabase): FeedbackDao = db.feedbackDao()

    @Provides
    fun provideProjectUpdateDao(db: GramaSuvidhaDatabase): ProjectUpdateDao = db.projectUpdateDao()
}
