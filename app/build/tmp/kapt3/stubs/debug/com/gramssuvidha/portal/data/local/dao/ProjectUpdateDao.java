package com.gramssuvidha.portal.data.local.dao;

/**
 * DAO for project timeline update operations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/gramssuvidha/portal/data/local/dao/ProjectUpdateDao;", "", "deleteUpdatesForProject", "", "projectId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUpdatesForProject", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/gramssuvidha/portal/data/local/entity/ProjectUpdateEntity;", "insertUpdate", "update", "(Lcom/gramssuvidha/portal/data/local/entity/ProjectUpdateEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUpdates", "updates", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ProjectUpdateDao {
    
    @androidx.room.Query(value = "SELECT * FROM project_updates WHERE projectId = :projectId ORDER BY updatedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.gramssuvidha.portal.data.local.entity.ProjectUpdateEntity>> getUpdatesForProject(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUpdates(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gramssuvidha.portal.data.local.entity.ProjectUpdateEntity> updates, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUpdate(@org.jetbrains.annotations.NotNull()
    com.gramssuvidha.portal.data.local.entity.ProjectUpdateEntity update, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM project_updates WHERE projectId = :projectId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteUpdatesForProject(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}