package com.gramssuvidha.portal.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u001a4\u0010\u000b\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u001a\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003\u001a(\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003\u001a.\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003\u001a2\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 \u001a \u0010!\u001a\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150#2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006$"}, d2 = {"FilterChipsRow", "", "selectedFilter", "Lcom/gramssuvidha/portal/domain/model/ProjectStatus;", "onFilterSelected", "Lkotlin/Function1;", "HomeHeader", "panchayatName", "", "onSettingsClick", "Lkotlin/Function0;", "HomeScreen", "onProjectClick", "viewModel", "Lcom/gramssuvidha/portal/ui/home/HomeViewModel;", "InsightBanner", "insight", "modifier", "Landroidx/compose/ui/Modifier;", "ProjectCard", "project", "Lcom/gramssuvidha/portal/domain/model/Project;", "onClick", "SearchBar", "query", "onQueryChange", "StatCard", "label", "value", "color", "Landroidx/compose/ui/graphics/Color;", "StatCard-9LQNqLg", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;)V", "StatsRow", "projects", "", "app_release"})
public final class HomeScreenKt {
    
    /**
     * Home screen — the app's main "Digital Village Notice Board".
     */
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onProjectClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSettingsClick, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.ui.home.HomeViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void HomeHeader(java.lang.String panchayatName, kotlin.jvm.functions.Function0<kotlin.Unit> onSettingsClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void InsightBanner(java.lang.String insight, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StatsRow(java.util.List<com.gramssuvidha.portal.domain.model.Project> projects, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SearchBar(java.lang.String query, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onQueryChange, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void FilterChipsRow(com.gramssuvidha.portal.domain.model.ProjectStatus selectedFilter, kotlin.jvm.functions.Function1<? super com.gramssuvidha.portal.domain.model.ProjectStatus, kotlin.Unit> onFilterSelected) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    private static final void ProjectCard(com.gramssuvidha.portal.domain.model.Project project, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, androidx.compose.ui.Modifier modifier) {
    }
}