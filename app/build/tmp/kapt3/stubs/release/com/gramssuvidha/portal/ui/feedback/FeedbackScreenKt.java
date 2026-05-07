package com.gramssuvidha.portal.ui.feedback;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0003\u001a>\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0003\u001a.\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00032\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0002\b\u0014\u00a2\u0006\u0002\b\u0015H\u0003\u001a0\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007\u001a\b\u0010\u001d\u001a\u00020\u0001H\u0003\u001a$\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u0006H\u0003\u001a\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0003H\u0003\u001a.\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0003\u00a8\u0006\'"}, d2 = {"CitizenInfoSection", "", "name", "", "contact", "onNameChange", "Lkotlin/Function1;", "onContactChange", "nameError", "CommentSection", "comment", "onCommentChange", "aiCategory", "isAiCategorizing", "", "error", "FeedbackCard", "title", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "FeedbackScreen", "projectId", "projectTitle", "onBack", "Lkotlin/Function0;", "viewModel", "Lcom/gramssuvidha/portal/ui/feedback/FeedbackViewModel;", "ImageUploadPlaceholder", "IssueTypeSection", "selected", "Lcom/gramssuvidha/portal/domain/model/IssueType;", "onSelect", "ProjectBanner", "StarRatingSection", "rating", "", "onRatingChange", "app_release"})
public final class FeedbackScreenKt {
    
    /**
     * Feedback screen — citizen form with star rating, issue type, and AI categorization.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void FeedbackScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId, @org.jetbrains.annotations.NotNull()
    java.lang.String projectTitle, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.ui.feedback.FeedbackViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ProjectBanner(java.lang.String title) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StarRatingSection(int rating, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onRatingChange, java.lang.String error) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.layout.ExperimentalLayoutApi.class})
    @androidx.compose.runtime.Composable()
    private static final void IssueTypeSection(com.gramssuvidha.portal.domain.model.IssueType selected, kotlin.jvm.functions.Function1<? super com.gramssuvidha.portal.domain.model.IssueType, kotlin.Unit> onSelect) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CommentSection(java.lang.String comment, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCommentChange, java.lang.String aiCategory, boolean isAiCategorizing, java.lang.String error) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CitizenInfoSection(java.lang.String name, java.lang.String contact, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNameChange, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onContactChange, java.lang.String nameError) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ImageUploadPlaceholder() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void FeedbackCard(java.lang.String title, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.ColumnScope, kotlin.Unit> content) {
    }
}