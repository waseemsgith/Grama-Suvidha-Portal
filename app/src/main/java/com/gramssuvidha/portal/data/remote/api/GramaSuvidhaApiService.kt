package com.gramssuvidha.portal.data.remote.api

import com.gramssuvidha.portal.data.remote.model.FeedbackDto
import com.gramssuvidha.portal.data.remote.model.FeedbackResponse
import com.gramssuvidha.portal.data.remote.model.ProjectUpdatesResponse
import com.gramssuvidha.portal.data.remote.model.ProjectsResponse
import retrofit2.http.*

/**
 * Retrofit API service interface for the Grama Suvidha backend.
 * In this version, requests are intercepted by MockApiInterceptor.
 */
interface GramaSuvidhaApiService {

    @GET("api/v1/projects")
    suspend fun getProjects(): ProjectsResponse

    @GET("api/v1/projects/{id}/updates")
    suspend fun getProjectUpdates(@Path("id") projectId: String): ProjectUpdatesResponse

    @POST("api/v1/feedback")
    suspend fun submitFeedback(@Body feedback: FeedbackDto): FeedbackResponse
}
