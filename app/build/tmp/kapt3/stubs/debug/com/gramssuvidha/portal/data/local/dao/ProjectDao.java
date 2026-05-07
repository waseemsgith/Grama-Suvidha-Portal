package com.gramssuvidha.portal.data.local.dao;

/**
 * DAO for project-related database operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\u0006\u0010\r\u001a\u00020\u000eH\'J\u000e\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/gramssuvidha/portal/data/local/dao/ProjectDao;", "", "deleteAllProjects", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProject", "project", "Lcom/gramssuvidha/portal/data/local/entity/ProjectEntity;", "(Lcom/gramssuvidha/portal/data/local/entity/ProjectEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllProjects", "Lkotlinx/coroutines/flow/Flow;", "", "getProjectById", "id", "", "getProjectCount", "", "insertProject", "insertProjects", "projects", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ProjectDao {
    
    @androidx.room.Query(value = "SELECT * FROM projects ORDER BY lastUpdated DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.gramssuvidha.portal.data.local.entity.ProjectEntity>> getAllProjects();
    
    @androidx.room.Query(value = "SELECT * FROM projects WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.gramssuvidha.portal.data.local.entity.ProjectEntity> getProjectById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertProjects(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gramssuvidha.portal.data.local.entity.ProjectEntity> projects, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertProject(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.local.entity.ProjectEntity project, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteProject(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.local.entity.ProjectEntity project, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM projects")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllProjects(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM projects")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getProjectCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}