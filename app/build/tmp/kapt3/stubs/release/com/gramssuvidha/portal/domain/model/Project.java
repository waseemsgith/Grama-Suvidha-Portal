package com.gramssuvidha.portal.domain.model;

/**
 * Domain model representing a Panchayat infrastructure project.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00d1\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\u0002\u0010 J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u000bH\u00c6\u0003J\t\u0010F\u001a\u00020\u000bH\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u00c6\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u001fH\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0007H\u00c6\u0003J\t\u0010Q\u001a\u00020\tH\u00c6\u0003J\t\u0010R\u001a\u00020\u000bH\u00c6\u0003J\t\u0010S\u001a\u00020\u000bH\u00c6\u0003J\t\u0010T\u001a\u00020\u000eH\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\u0083\u0002\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u00c6\u0001J\u0013\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Z\u001a\u00020\u000eH\u00d6\u0001J\t\u0010[\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\"R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\"\u00a8\u0006\\"}, d2 = {"Lcom/gramssuvidha/portal/domain/model/Project;", "", "id", "", "title", "description", "category", "Lcom/gramssuvidha/portal/domain/model/ProjectCategory;", "status", "Lcom/gramssuvidha/portal/domain/model/ProjectStatus;", "budget", "", "budgetSpent", "progressPercent", "", "contractor", "contractorContact", "startDate", "expectedCompletionDate", "actualCompletionDate", "location", "latitude", "longitude", "ward", "panchayatName", "imageUrls", "", "beforeImages", "afterImages", "aiSummary", "lastUpdated", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/gramssuvidha/portal/domain/model/ProjectCategory;Lcom/gramssuvidha/portal/domain/model/ProjectStatus;DDILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;J)V", "getActualCompletionDate", "()Ljava/lang/String;", "getAfterImages", "()Ljava/util/List;", "getAiSummary", "getBeforeImages", "getBudget", "()D", "getBudgetSpent", "getCategory", "()Lcom/gramssuvidha/portal/domain/model/ProjectCategory;", "getContractor", "getContractorContact", "getDescription", "getExpectedCompletionDate", "getId", "getImageUrls", "getLastUpdated", "()J", "getLatitude", "getLocation", "getLongitude", "getPanchayatName", "getProgressPercent", "()I", "getStartDate", "getStatus", "()Lcom/gramssuvidha/portal/domain/model/ProjectStatus;", "getTitle", "getWard", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
public final class Project {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.model.ProjectCategory category = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gramssuvidha.portal.domain.model.ProjectStatus status = null;
    private final double budget = 0.0;
    private final double budgetSpent = 0.0;
    private final int progressPercent = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contractor = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contractorContact = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String startDate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String expectedCompletionDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String actualCompletionDate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String location = null;
    private final double latitude = 0.0;
    private final double longitude = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ward = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String panchayatName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> imageUrls = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> beforeImages = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> afterImages = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String aiSummary = null;
    private final long lastUpdated = 0L;
    
    public Project(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.model.ProjectCategory category, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.model.ProjectStatus status, double budget, double budgetSpent, int progressPercent, @org.jetbrains.annotations.NotNull()
    java.lang.String contractor, @org.jetbrains.annotations.NotNull()
    java.lang.String contractorContact, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String expectedCompletionDate, @org.jetbrains.annotations.Nullable()
    java.lang.String actualCompletionDate, @org.jetbrains.annotations.NotNull()
    java.lang.String location, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    java.lang.String ward, @org.jetbrains.annotations.NotNull()
    java.lang.String panchayatName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> imageUrls, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> beforeImages, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> afterImages, @org.jetbrains.annotations.NotNull()
    java.lang.String aiSummary, long lastUpdated) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gramssuvidha.portal.domain.model.ProjectCategory getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gramssuvidha.portal.domain.model.ProjectStatus getStatus() {
        return null;
    }
    
    public final double getBudget() {
        return 0.0;
    }
    
    public final double getBudgetSpent() {
        return 0.0;
    }
    
    public final int getProgressPercent() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContractor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContractorContact() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStartDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExpectedCompletionDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActualCompletionDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWard() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPanchayatName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getImageUrls() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBeforeImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getAfterImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAiSummary() {
        return null;
    }
    
    public final long getLastUpdated() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    public final double component15() {
        return 0.0;
    }
    
    public final double component16() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    public final long component23() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gramssuvidha.portal.domain.model.ProjectCategory component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gramssuvidha.portal.domain.model.ProjectStatus component5() {
        return null;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gramssuvidha.portal.domain.model.Project copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.model.ProjectCategory category, @org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.domain.model.ProjectStatus status, double budget, double budgetSpent, int progressPercent, @org.jetbrains.annotations.NotNull()
    java.lang.String contractor, @org.jetbrains.annotations.NotNull()
    java.lang.String contractorContact, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String expectedCompletionDate, @org.jetbrains.annotations.Nullable()
    java.lang.String actualCompletionDate, @org.jetbrains.annotations.NotNull()
    java.lang.String location, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    java.lang.String ward, @org.jetbrains.annotations.NotNull()
    java.lang.String panchayatName, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> imageUrls, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> beforeImages, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> afterImages, @org.jetbrains.annotations.NotNull()
    java.lang.String aiSummary, long lastUpdated) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}