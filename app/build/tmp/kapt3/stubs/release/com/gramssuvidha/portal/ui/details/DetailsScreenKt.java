package com.gramssuvidha.portal.ui.details;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001aB\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007\u001a4\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0007H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a.\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0003\u001a.\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00032\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00010&\u00a2\u0006\u0002\b(\u00a2\u0006\u0002\b)H\u0003\u001a\u0018\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\"H\u0003\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006-"}, d2 = {"BudgetCard", "", "label", "", "amount", "icon", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "BudgetCard-42QJj7c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;)V", "DetailsScreen", "projectId", "onBack", "Lkotlin/Function0;", "onFeedbackClick", "Lkotlin/Function2;", "viewModel", "Lcom/gramssuvidha/portal/ui/details/DetailsViewModel;", "InfoRow", "value", "Landroidx/compose/ui/graphics/vector/ImageVector;", "valueColor", "InfoRow-g2O1Hgs", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;J)V", "ProjectDetailContent", "project", "Lcom/gramssuvidha/portal/domain/model/Project;", "updates", "", "Lcom/gramssuvidha/portal/domain/model/ProjectUpdate;", "aiSummary", "isAiLoading", "", "SectionCard", "title", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "TimelineItem", "update", "isLast", "app_release"})
public final class DetailsScreenKt {
    
    /**
     * Project Details screen — full project dashboard with timeline and AI insight.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void DetailsScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onFeedbackClick, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.ui.details.DetailsViewModel viewModel) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    private static final void ProjectDetailContent(com.gramssuvidha.portal.domain.model.Project project, java.util.List<com.gramssuvidha.portal.domain.model.ProjectUpdate> updates, java.lang.String aiSummary, boolean isAiLoading) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SectionCard(java.lang.String title, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.ColumnScope, kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TimelineItem(com.gramssuvidha.portal.domain.model.ProjectUpdate update, boolean isLast) {
    }
}