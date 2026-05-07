package com.gramssuvidha.portal.di

import com.gramssuvidha.portal.data.repository.AIRepositoryImpl
import com.gramssuvidha.portal.data.repository.FeedbackRepositoryImpl
import com.gramssuvidha.portal.data.repository.ProjectRepositoryImpl
import com.gramssuvidha.portal.domain.repository.AIRepository
import com.gramssuvidha.portal.domain.repository.FeedbackRepository
import com.gramssuvidha.portal.domain.repository.ProjectRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module binding domain repository interfaces to their implementations.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProjectRepository(impl: ProjectRepositoryImpl): ProjectRepository

    @Binds
    @Singleton
    abstract fun bindFeedbackRepository(impl: FeedbackRepositoryImpl): FeedbackRepository

    @Binds
    @Singleton
    abstract fun bindAIRepository(impl: AIRepositoryImpl): AIRepository
}
